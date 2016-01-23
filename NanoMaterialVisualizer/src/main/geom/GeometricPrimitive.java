package main.geom;

import java.awt.Graphics;

/**
@author Alexey
 */
public interface GeometricPrimitive {

    void draw(Graphics graphics, int width, int height);

    void multiOnMatrix(float[][] matrix);

}
