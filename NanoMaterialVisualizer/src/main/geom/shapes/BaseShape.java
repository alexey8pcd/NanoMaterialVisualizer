package main.geom.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import main.geom.Matrix;
import main.geom.MatrixMultiplied;
import main.geom.Drawable;
import main.geom.primitive.Primitive3D;

/**
 * @author Alexey
 */
public class BaseShape implements Shape {

    protected List<Primitive3D> primitives;

    public BaseShape() {
        primitives = new ArrayList<>();
    }

    public void addPrimitive(Primitive3D primitive) {
        this.primitives.add(primitive);
    }

    @Override
    public void draw(Graphics graphics, int width, int heigth) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, heigth);
        graphics.setColor(Color.RED);
        for (Drawable primitive : primitives) {
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
        for (MatrixMultiplied primitive : primitives) {
            primitive.multiOnMatrix(matrixX);
            primitive.multiOnMatrix(matrixY);
        }
    }

    @Override
    public void scale(double value) {
        float[][] matrix = Matrix.makeScaleMatrix(value);
        for (MatrixMultiplied primitive : primitives) {
            primitive.multiOnMatrix(matrix);
        }
    }

    @Override
    public void translate(int dx, int dy) {
        float[][] matrix = Matrix.makeIdentityMatrix();
        matrix[3][0] = dx;
        matrix[3][1] = dy;
        for (MatrixMultiplied primitive : primitives) {
            primitive.multiOnMatrix(matrix);
        }
    }

}
