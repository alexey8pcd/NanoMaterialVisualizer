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
public class GraphenCreator {

    private final int pointsHorizontal = 20;
    private final int pointsVertical = 20;
    private final List<List<Vertex3F>> vertexes;

    public GraphenCreator() {
        vertexes = new ArrayList<>(pointsVertical);
    }

    public void create() {
        int startX = 50;
        int startY = 50;
        int dx = 50;
        int dx2 = dx * 2;
        int dy = 20;
        float y = startY;
        float x;
        float z = 0;
        for (int j = 0; j < pointsVertical; j++) {
            if (j % 2 == 0) {
                x = startX;
            } else {
                x = startX + dx * 3 / 2;
            }
            List<Vertex3F> row = new ArrayList<>(pointsHorizontal);
            for (int i = 0; i < pointsHorizontal; i++) {
                row.add(new Vertex3F(x, y, z));
                if (i % 2 == 0) {
                    x += dx;
                } else {
                    x += dx2;
                }
            }
            vertexes.add(row);
            y += dy;
        }
        try {
            try (BufferedWriter bufferedWriter
                    = new BufferedWriter(new FileWriter("graphen.txt"))) {
                for (int i = 0; i < pointsVertical - 3; i += 2) {
                    List<Vertex3F> layerA1 = vertexes.get(i);
                    List<Vertex3F> layerB1 = vertexes.get(i + 1);
                    List<Vertex3F> layerC1 = vertexes.get(i + 2);
                    List<Vertex3F> layerD1 = vertexes.get(i + 3);
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
        for (int i = 1; i < pointsHorizontal - 1; i += 2) {
            Vertex3F[] vertes = new Vertex3F[6];
            vertes[0] = layerB.get(i - 1);
            vertes[1] = layerB.get(i);
            vertes[2] = layerC.get(i + 1);
            vertes[3] = layerD.get(i);
            vertes[4] = layerD.get(i - 1);
            vertes[5] = layerC.get(i);
            result.add(Arrays.toString(vertes));
        }
        return result;
    }

    private List<String> createLayerUneven(List<Vertex3F> layerA,
            List<Vertex3F> layerB, List<Vertex3F> layerC) {
        List<String> result = new LinkedList<>();
        for (int i = 2; i < pointsHorizontal - 1; i += 2) {
            Vertex3F[] vertes = new Vertex3F[6];
            vertes[0] = layerA.get(i);
            vertes[1] = layerA.get(i + 1);
            vertes[2] = layerB.get(i);
            vertes[3] = layerC.get(i + 1);
            vertes[4] = layerC.get(i);
            vertes[5] = layerB.get(i - 1);
            result.add(Arrays.toString(vertes));
        }
        return result;

    }

}
