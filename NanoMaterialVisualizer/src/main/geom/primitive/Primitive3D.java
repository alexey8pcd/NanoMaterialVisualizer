package main.geom.primitive;

import java.awt.Graphics;
import main.geom.Vertex3F;

/**
 * @author Alexey
 */
public class Primitive3D implements GeometricPrimitive {

    protected final int edgeCount;
    protected final int vertexesCount;
    protected final Vertex3F[] vertexes;

    public static boolean inField(float x, float y, int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Primitive3D(int edgeCount, int vertexesCount) {
        this.edgeCount = edgeCount;
        this.vertexesCount = vertexesCount;
        vertexes = new Vertex3F[vertexesCount];
    }

    public void setVertex(Vertex3F vertex, int index) {
        vertexes[index] = vertex;
    }

    @Override
    public void draw(Graphics graphics, int width, int height) {
        for (int i = 0; i < vertexesCount - 1; i++) {
            drawEdge(i, i + 1, graphics, width, height);
        }
        drawEdge(vertexesCount - 1, 0, graphics, width, height);
    }

    protected void drawEdge(int index1, int index2, Graphics graphics, int width, int height) {
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

    @Override
    public void multiOnMatrix(float[][] matrix) {
        for (Vertex3F vertex3F : vertexes) {
            vertex3F.multiOnMatrix(matrix);
        }
    }

}
