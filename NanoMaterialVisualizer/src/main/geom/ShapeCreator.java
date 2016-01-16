package main.geom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey
 */
public class ShapeCreator {

    private final int layersCount = 20;
    private final List<List<Vertex3F>> layers;
    private final int rangeBetweenLayers = 40;
    private final double radius = 100;
    private final int elementsCount = 12;

    public ShapeCreator() {
        layers = new ArrayList<>(layersCount);
    }

    public void create() {
        double t;
        double dt = Math.PI * 2 / elementsCount;
        double z = 0;
        for (int i = 0; i < layersCount; i++) {
            if (i % 2 == 0) {
                t = 0;
            } else {
                t = dt * 3 / 2;
            }
//            System.out.println("-------------" + (i + 1));
            List<Vertex3F> layer = makePoints(elementsCount, t, radius, z, dt);
            layers.add(layer);
            z += rangeBetweenLayers;
        }
        for (int i = 0; i < layersCount - 3; i += 2) {
            List<Vertex3F> layerA1 = layers.get(i);
            List<Vertex3F> layerB1 = layers.get(i + 1);
            List<Vertex3F> layerC1 = layers.get(i + 2);
            List<Vertex3F> layerD1 = layers.get(i + 3);
            printLayer(layerA1, layerB1, layerC1);
            printLayerEven(layerB1, layerC1, layerD1);
        }

    }

    private void printLayerEven(List<Vertex3F> layerB, List<Vertex3F> layerC, List<Vertex3F> layerD) {
        for (int i = 1; i < elementsCount - 1; i += 2) {
            Vertex3F[] v = new Vertex3F[6];
            v[0] = layerB.get(i - 1);
            v[1] = layerB.get(i);
            v[2] = layerC.get(i + 1);
            v[3] = layerD.get(i);
            v[4] = layerD.get(i - 1);
            v[5] = layerC.get(i);
            System.out.println(Arrays.toString(v));
        }
    }

    private void printLayer(List<Vertex3F> layerA, List<Vertex3F> layerB, List<Vertex3F> layerC) {
        for (int i = 2; i < elementsCount - 1; i += 2) {
            Vertex3F[] v = new Vertex3F[6];
            v[0] = layerA.get(i);
            v[1] = layerA.get(i + 1);
            v[2] = layerB.get(i);
            v[3] = layerC.get(i + 1);
            v[4] = layerC.get(i);
            v[5] = layerB.get(i - 1);
            System.out.println(Arrays.toString(v));
        }
    }

    private List<Vertex3F> makePoints(int elementsCount, double t, double radius, double z, double dt) {
        List<Vertex3F> layer = new ArrayList<>(elementsCount);
        for (int i = 0; i < elementsCount; i++) {
            double x = Math.sin(t) * radius;
            double y = Math.cos(t) * radius;
//            System.out.println("x: " + x + ";         y: " + y + ";      z: " + z);
            layer.add(new Vertex3F(x, y, z));
            if (i % 2 == 0) {
                t += dt;
            } else {
                t += 2 * dt;
            }
        }
        return layer;
    }

    public static void main(String[] args) {
        new ShapeCreator().create();
    }
}
