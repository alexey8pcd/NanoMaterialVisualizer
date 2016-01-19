package main.geom;

/**
 * @author Alexey
 */
public class Vertex3F {

    private float x;
    private float y;
    private float z;

    public Vertex3F(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vertex3F(double x, double y, double z) {
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void multiOnMatrix(float[][] matrix) {
        float xn = x * matrix[0][0] + y * matrix[1][0]
                + z * matrix[2][0] + matrix[3][0];
        float yn = x * matrix[0][1] + y * matrix[1][1]
                + z * matrix[2][1] + matrix[3][1];
        float zn = x * matrix[0][2] + y * matrix[1][2]
                + z * matrix[2][2] + matrix[3][2];
        float dn = x * matrix[0][3] + y * matrix[1][3]
                + z * matrix[2][3] + matrix[3][3];
        x = xn / dn;
        y = yn / dn;
        z = zn / dn;
    }

    @Override
    public String toString() {
        return x + ";" + y + ";" + z;
    }

}
