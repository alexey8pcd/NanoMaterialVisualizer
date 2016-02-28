package main.geom.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import main.geom.primitive.GeometricPrimitive;
import main.geom.Matrix;

/**
 * @author Alexey
 */
public class BaseShape implements Shape {

    protected List<GeometricPrimitive> primitives;

    public BaseShape() {
        primitives = new ArrayList<>();
    }

    public void addPrimitive(GeometricPrimitive primitive) {
        this.primitives.add(primitive);
    }

    @Override
    public void draw(Graphics graphics, int width, int heigth) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, heigth);
        graphics.setColor(Color.RED);
        for (GeometricPrimitive primitive : primitives) {
            primitive.draw(graphics, width, heigth);
        }
    }

    /**
     *
     * @param dx [-1.0; 1.0]
     * @param dy [-1.0; 1.0]
     */
    @Override
    public void rotate(double dx, double dy) {
        double t = dx + Math.signum(dx);
        dx = dy + Math.signum(dy);
        dy = t;
        float[][] matrixX = Matrix.makeRotateMatrixX(dx * dx * dx);
        float[][] matrixY = Matrix.makeRotateMatrixY(dy * dy * dy);
        for (GeometricPrimitive primitive : primitives) {
            primitive.multiOnMatrix(matrixX);
            primitive.multiOnMatrix(matrixY);
        }
    }

    @Override
    public void scale(double value) {
        float[][] matrix = Matrix.makeScaleMatrix(value);
        for (GeometricPrimitive primitive : primitives) {
            primitive.multiOnMatrix(matrix);
        }
    }

}
