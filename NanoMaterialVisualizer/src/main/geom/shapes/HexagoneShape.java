package main.geom.shapes;

import main.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey
 */
public class HexagoneShape implements Shape {

    private final List<GeometricPrimitive> hexagones;

    public HexagoneShape() {
        hexagones = new ArrayList<>();
    }

    public void addHexagone(GeometricPrimitive hexagone) {
        this.hexagones.add(hexagone);
    }

    @Override
    public void draw(Graphics graphics, int width, int heigth) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, heigth);
        graphics.setColor(Color.RED);
        for (GeometricPrimitive hexagone : hexagones) {
            hexagone.draw(graphics, width, heigth);
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
        for (GeometricPrimitive hexagone : hexagones) {
            hexagone.multiOnMatrix(matrixX);
            hexagone.multiOnMatrix(matrixY);
        }
    }

    @Override
    public void scale(double value) {
        float[][] matrix = Matrix.makeScaleMatrix(value);
        for (GeometricPrimitive hexagone : hexagones) {
            hexagone.multiOnMatrix(matrix);
        }
    }

}
