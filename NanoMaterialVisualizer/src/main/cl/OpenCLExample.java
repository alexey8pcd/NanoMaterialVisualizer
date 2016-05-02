package main.cl;

import java.io.File;
import java.util.List;
import java.nio.FloatBuffer;
import java.util.Locale;
import static main.cl.UtilCL.print;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CL;
import static org.lwjgl.opencl.CL10.*;

import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLKernel;
import org.lwjgl.opencl.CLMem;
import org.lwjgl.opencl.CLPlatform;
import org.lwjgl.opencl.CLProgram;
import org.lwjgl.opencl.Util;

/**
 * @author Alexey
 */
public class OpenCLExample {
// Data buffers to store the input and result data in

    static final FloatBuffer a = UtilCL.toFloatBuffer(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    static final FloatBuffer b = UtilCL.toFloatBuffer(new float[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
    static final FloatBuffer answer = BufferUtils.createFloatBuffer(a.capacity());

    public static void displayInfo() {

        for (int platformIndex = 0; platformIndex < CLPlatform.getPlatforms().size(); platformIndex++) {
            CLPlatform platform = CLPlatform.getPlatforms().get(platformIndex);
            System.out.println("Platform #" + platformIndex + ":" + platform.getInfoString(CL_PLATFORM_NAME));
            List<CLDevice> devices = platform.getDevices(CL_DEVICE_TYPE_ALL);
            for (int deviceIndex = 0; deviceIndex < devices.size(); deviceIndex++) {
                CLDevice device = devices.get(deviceIndex);
                System.out.printf(Locale.ENGLISH, "Device #%d(%s):%s\n",
                        deviceIndex,
                        UtilCL.getDeviceType(device.getInfoInt(CL_DEVICE_TYPE)),
                        device.getInfoString(CL_DEVICE_NAME));
                System.out.printf(Locale.ENGLISH, "\tCompute Units: %d @ %d mghtz\n",
                        device.getInfoInt(CL_DEVICE_MAX_COMPUTE_UNITS), device.getInfoInt(CL_DEVICE_MAX_CLOCK_FREQUENCY));
                System.out.printf(Locale.ENGLISH, "\tLocal memory: %s\n",
                        UtilCL.formatMemory(device.getInfoLong(CL_DEVICE_LOCAL_MEM_SIZE)));
                System.out.printf(Locale.ENGLISH, "\tGlobal memory: %s\n",
                        UtilCL.formatMemory(device.getInfoLong(CL_DEVICE_GLOBAL_MEM_SIZE)));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("org.lwjgl.librarypath",
                new File(new File(System.getProperty("user.dir"), "native"),
                        LWJGLUtil.getPlatformName()).getAbsolutePath());
        // Initialize OpenCL and create a context and command queue
        CL.create();

        displayInfo();

        CLPlatform platform = CLPlatform.getPlatforms().get(0);
        List<CLDevice> devices = platform.getDevices(CL_DEVICE_TYPE_GPU);
        CLContext context = CLContext.create(platform, devices, null, null, null);
//        System.err.println("dev " + devices.size());
        CLCommandQueue queue = clCreateCommandQueue(context, devices.get(0), CL_QUEUE_PROFILING_ENABLE, null);

        // Allocate memory for our two input buffers and our result buffer
        CLMem aMem = clCreateBuffer(context, CL_MEM_READ_ONLY | CL_MEM_COPY_HOST_PTR, a, null);
        clEnqueueWriteBuffer(queue, aMem, 1, 0, a, null, null);
        CLMem bMem = clCreateBuffer(context, CL_MEM_READ_ONLY | CL_MEM_COPY_HOST_PTR, b, null);
        clEnqueueWriteBuffer(queue, bMem, 1, 0, b, null, null);
        CLMem answerMem = clCreateBuffer(context, CL_MEM_WRITE_ONLY | CL_MEM_COPY_HOST_PTR, answer, null);
        clFinish(queue);

        // Load the source from a resource file
        String source = UtilCL.getResourceAsString("D:\\Study\\ПМиКС\\"
                + "NanoMaterialVisualizer\\NanoMaterialVisualizer\\src\\main\\cl\\sum.txt");
//        String source = UtilCL.getResourceAsString("cl/sum.txt");

        // Create our program and kernel
        CLProgram program = clCreateProgramWithSource(context, source, null);
        Util.checkCLError(clBuildProgram(program, devices.get(0), "", null));
        // sum has to match a kernel method name in the OpenCL source
        CLKernel kernel = clCreateKernel(program, "sum", null);

        // Execution our kernel
        PointerBuffer kernel1DGlobalWorkSize = BufferUtils.createPointerBuffer(1);
        kernel1DGlobalWorkSize.put(0, a.capacity());
        kernel.setArg(0, aMem);
        kernel.setArg(1, bMem);
        kernel.setArg(2, answerMem);
        clEnqueueNDRangeKernel(queue, kernel, 1, null, kernel1DGlobalWorkSize, null, null, null);

        // Read the results memory back into our result buffer
        clEnqueueReadBuffer(queue, answerMem, 1, 0, answer, null, null);
        clFinish(queue);
        // Print the result memory
        print(a);
        System.out.println("+");
        print(b);
        System.out.println("=");
        print(answer);

        // Clean up OpenCL resources
        clReleaseKernel(kernel);
        clReleaseProgram(program);
        clReleaseMemObject(aMem);
        clReleaseMemObject(bMem);
        clReleaseMemObject(answerMem);
        clReleaseCommandQueue(queue);
        clReleaseContext(context);
        CL.destroy();
    }
}
