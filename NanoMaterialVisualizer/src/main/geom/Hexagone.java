package main.geom;

import java.awt.Graphics;

/**
 * @author Alexey
 */
public class Hexagone {

    private final Vertex3F[] vertexes;
    static final int EDGE_COUNT = 6;

    public Hexagone() {
        vertexes = new Vertex3F[EDGE_COUNT];
    }

    void setVertex(Vertex3F vertex, int index) {
        vertexes[index] = vertex;
    }

    public void draw(Graphics graphics, int width, int height) {
        for (int i = 0; i < EDGE_COUNT - 1; i++) {
            drawEdge(i, i + 1, graphics, width, height);
        }
        drawEdge(EDGE_COUNT - 1, 0, graphics, width, height);
    }

    private void drawEdge(int index1, int index2, Graphics graphics, int width, int height) {
        Vertex3F vertex1 = vertexes[index1];
        Vertex3F vertex2 = vertexes[index2];
        int dx = width / 4;
        int x = (int) vertex1.getX() + dx;
        int dy = height - height / 4;
        int y = (int) (dy - vertex1.getY());
        int x2 = (int) vertex2.getX() + dx;
        int y2 = (int) (dy - vertex2.getY());
        if (inField(x, y, width, height) && inField(x2, y2, width, height)) {
            graphics.drawLine(x, y, x2, y2);
        }
    }

    private static boolean inField(float x, float y, int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void multiOnMatrix(float[][] matrix) {
        for (Vertex3F vertex3F : vertexes) {
            vertex3F.multiOnMatrix(matrix);
        }
    }
}
