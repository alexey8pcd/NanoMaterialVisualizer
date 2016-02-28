package main.geom.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import main.geom.primitive.GeometricPrimitive;
import main.geom.Matrix;
import main.geom.primitive.Primitive3D;
import main.geom.Vertex3F;

/**
 * @author Alexey
 */
public class Fulleren extends BaseShape {

    private final List<Vertex3F> vertexes;
    private static final int VERTEX_COUNT = 60;

    public Fulleren() {
        super();
        vertexes = new ArrayList<>(VERTEX_COUNT);
    }

    public void addVertex(Vertex3F vertex3F) {
        this.vertexes.add(vertex3F);
    }

    public void build() {
        primitives.clear();
        List<Vertex3F> temp = new ArrayList<>(vertexes);
        for (Iterator<Vertex3F> iterator = temp.iterator(); iterator.hasNext();) {
            Vertex3F vertex = iterator.next();
            Vertex3F n1 = findNearest(vertex);
            Vertex3F n2 = findNearest(vertex, n1);
            Vertex3F n3 = findNearest(vertex, n1, n2);
            primitives.add(createEdge(vertex, n1));
            primitives.add(createEdge(vertex, n2));
            primitives.add(createEdge(vertex, n3));
            iterator.remove();
        }
    }

    private Primitive3D createEdge(Vertex3F vertexe, Vertex3F n1) {
        Primitive3D edge = new Primitive3D(1, 2);
        edge.setVertex(vertexe, 0);
        edge.setVertex(n1, 1);
        return edge;
    }

    private Vertex3F findNearest(Vertex3F to, Vertex3F... exclude) {
        Vertex3F nearest = null;
        double minDistance = Double.MAX_VALUE;
        c1:
        for (Vertex3F v : vertexes) {
            if (v == to) {
                continue;
            }
            if (exclude.length > 0) {
                for (Vertex3F e : exclude) {
                    if (e == v) {
                        continue c1;
                    }
                }
            }
            double dist1 = v.distanceTo(to);
            if (dist1 < minDistance) {
                minDistance = dist1;
                nearest = v;
            }
        }
        return nearest;
    }

    @Override
    public void draw(Graphics graphics, int width, int height) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.RED);
        for (GeometricPrimitive edge : primitives) {
            edge.draw(graphics, width, height);
        }
    }

    @Override
    public void rotate(double dx, double dy) {
        double t = dx + Math.signum(dx);
        dx = dy + Math.signum(dy);
        dy = t;
        double dxP3 = dx * dx * dx;
        float[][] makeRotateMatrixX = Matrix.makeRotateMatrixX(dxP3);
        double dyP3 = dy * dy * dy;
        float[][] makeRotateMatrixY = Matrix.makeRotateMatrixY(dyP3);
        for (Vertex3F vertex3F : vertexes) {
            vertex3F.multiOnMatrix(makeRotateMatrixX);
            vertex3F.multiOnMatrix(makeRotateMatrixY);
        }
    }

    @Override
    public void scale(double value) {
        float[][] matrix = Matrix.makeScaleMatrix(value);
        for (Vertex3F vertex3F : vertexes) {
            vertex3F.multiOnMatrix(matrix);
        }
    }

}
