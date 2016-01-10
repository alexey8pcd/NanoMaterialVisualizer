package main.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey
 */
public class Shape {

    private final List<Hexagone> hexagones;

    public Shape() {
        hexagones = new ArrayList<>();
    }

    public void addHexagone(Hexagone hexagone) {
        this.hexagones.add(hexagone);
    }

    public void draw(Graphics graphics, int width, int heigth) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, heigth);
        graphics.setColor(Color.RED);
        for (Hexagone hexagone : hexagones) {
            hexagone.draw(graphics, width, heigth);
        }
    }

    public void rotate(double dx, double dy) {
        float[][] matrixX = makeRotateMatrixX(dx);
        float[][] matrixY = makeRotateMatrixY(dy);
        for (Hexagone hexagone : hexagones) {
            hexagone.multiOnMatrix(matrixX);
            hexagone.multiOnMatrix(matrixY);
        }
    }

    public void scale(double value) {
        float[][] matrix = makeScaleMatrix(value);
        for (Hexagone hexagone : hexagones) {
            hexagone.multiOnMatrix(matrix);
        }
    }

    private float[][] makeIdentityMatrix() {
        return new float[][]{
            {1, 0, 0, 0}, {0, 1, 0, 0},
            {0, 0, 1, 0}, {0, 0, 0, 1}
        };
    }

    private float[][] makeRotateMatrixX(double dx) {
        float[][] matrix = makeIdentityMatrix();
        double angleX = Math.PI / 4 * dx;
        matrix[1][1] = matrix[2][2] = (float) Math.cos(angleX);
        matrix[2][1] = matrix[1][2] = (float) Math.sin(angleX);
        return matrix;
    }

    private float[][] makeScaleMatrix(double value) {
        float[][] matrix = makeIdentityMatrix();
        float factor = 1.2f;
        if (value > 0) {
            factor = 0.8f;
        }
        matrix[0][0] = matrix[1][1] = matrix[2][2] = factor;
        return matrix;
    }

    private float[][] makeRotateMatrixY(double dy) {
        float[][] matrix = makeIdentityMatrix();
        double angleX = Math.PI / 4 * dy;
        matrix[0][0] = matrix[2][2] = (float) Math.cos(angleX);
        matrix[2][0] = matrix[0][2] = (float) Math.sin(angleX);
        return matrix;
    }

}
