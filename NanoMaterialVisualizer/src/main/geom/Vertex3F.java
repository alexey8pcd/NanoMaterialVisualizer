package main.geom;

/**
 * @author Alexey
 */
class Vertex3F {

    private float x;
    private float y;
    private float z;

    public Vertex3F(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    void multiOnMatrix(float[][] matrix) {
        float xn = 0;
        float yn = 0;
        float zn = 0;
        float dn = 0;
        for (float[] matrix1 : matrix) {
            xn += x * matrix1[0];
            yn += y * matrix1[1];
            zn += z * matrix1[2];
            dn += matrix1[3];
        }
        x = xn / dn;
        y = yn / dn;
        z = zn / dn;
    }

}
