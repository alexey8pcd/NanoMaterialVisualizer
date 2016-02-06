package main.geom;

/**
 * @author Alexey
 */
public class Matrix {

    public static float[][] makeIdentityMatrix() {
        return new float[][]{
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
    }

    public static float[][] makeRotateMatrixX(double dx) {
        float[][] matrix = makeIdentityMatrix();
        double angleX = Math.PI / 720 * dx;
        matrix[1][1] = matrix[2][2] = (float) Math.cos(angleX);
        matrix[1][2] = (float) Math.sin(angleX);
        matrix[2][1] = -matrix[1][2];
        return matrix;
    }

    public static float[][] makeScaleMatrix(double value) {
        float[][] matrix = makeIdentityMatrix();
        float factor = 1.2f;
        if (value < 0) {
            factor = 0.8f;
        }
        matrix[0][0] = matrix[1][1] = matrix[2][2] = factor;
        return matrix;
    }

    public static float[][] makeRotateMatrixY(double dy) {
        float[][] matrix = makeIdentityMatrix();
        double angleX = Math.PI / 720 * dy;
        matrix[0][0] = matrix[2][2] = (float) Math.cos(angleX);
        matrix[0][2] = (float) Math.sin(angleX);
        matrix[2][0] = -matrix[0][2];
        return matrix;
    }
}
