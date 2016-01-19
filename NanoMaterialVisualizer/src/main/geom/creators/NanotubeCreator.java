package main.geom.creators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import main.geom.Vertex3F;

/**
 * @author Alexey
 */
public class NanotubeCreator {

    private final int nanotubeLayersCount = 100;
    private final List<List<Vertex3F>> nanotubeLayers;
    private final int rangeBetweenLayers = 10;
    private final double radius = 100;
    private final int circlePointCount = 60;

    public NanotubeCreator() {
        nanotubeLayers = new ArrayList<>(nanotubeLayersCount);
    }

    public void create() {
        double t;
        double dt = Math.PI * 2 / circlePointCount;
        double z = 0;
        for (int i = 0; i < nanotubeLayersCount; i++) {
            if (i % 2 == 0) {
                t = 0;
            } else {
                t = dt * 3 / 2;
            }
            List<Vertex3F> layer = makePoints(circlePointCount, t, radius, z, dt);
            nanotubeLayers.add(layer);
            z += rangeBetweenLayers;
        }
        try {
            try (BufferedWriter bufferedWriter
                    = new BufferedWriter(new FileWriter("nanotube.txt"))) {
                for (int i = 0; i < nanotubeLayersCount - 3; i += 2) {
                    List<Vertex3F> layerA1 = nanotubeLayers.get(i);
                    List<Vertex3F> layerB1 = nanotubeLayers.get(i + 1);
                    List<Vertex3F> layerC1 = nanotubeLayers.get(i + 2);
                    List<Vertex3F> layerD1 = nanotubeLayers.get(i + 3);
                    List<String> layer1 = createLayerUneven(layerA1, layerB1, layerC1);
                    List<String> layer2 = createLayerEven(layerB1, layerC1, layerD1);
                    writeLayer(layer1, bufferedWriter);
                    writeLayer(layer2, bufferedWriter);
                }
                bufferedWriter.flush();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void writeLayer(List<String> strings,
            BufferedWriter bufferedWriter) throws IOException {
        for (String string : strings) {
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        }
    }

    private List<String> createLayerEven(List<Vertex3F> layerB,
            List<Vertex3F> layerC, List<Vertex3F> layerD) {
        List<String> result = new LinkedList<>();
        for (int i = 1; i < circlePointCount - 1; i += 2) {
            Vertex3F[] vertexes = new Vertex3F[6];
            vertexes[0] = layerB.get(i - 1);
            vertexes[1] = layerB.get(i);
            vertexes[2] = layerC.get(i + 1);
            vertexes[3] = layerD.get(i);
            vertexes[4] = layerD.get(i - 1);
            vertexes[5] = layerC.get(i);
            result.add(Arrays.toString(vertexes));
        }
        return result;
    }

    private List<String> createLayerUneven(List<Vertex3F> layerA,
            List<Vertex3F> layerB, List<Vertex3F> layerC) {
        List<String> result = new LinkedList<>();
        for (int i = 2; i < circlePointCount - 1; i += 2) {
            Vertex3F[] vertexes = new Vertex3F[6];
            vertexes[0] = layerA.get(i);
            vertexes[1] = layerA.get(i + 1);
            vertexes[2] = layerB.get(i);
            vertexes[3] = layerC.get(i + 1);
            vertexes[4] = layerC.get(i);
            vertexes[5] = layerB.get(i - 1);
            result.add(Arrays.toString(vertexes));
        }
        return result;
    }

    private List<Vertex3F> makePoints(int elementsCount, double t,
            double radius, double z, double dt) {
        List<Vertex3F> layer = new ArrayList<>(elementsCount);
        for (int i = 0; i < elementsCount; i++) {
            double x = Math.sin(t) * radius;
            double y = Math.cos(t) * radius;
            layer.add(new Vertex3F(x, y, z));
            if (i % 2 == 0) {
                t += dt;
            } else {
                t += 2 * dt;
            }
        }
        return layer;
    }

}
