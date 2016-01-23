package main.geom.shapes;

import java.awt.Graphics;

/**
@author Alexey
 */
public interface Shape {

    public void draw(Graphics graphics, int width, int height);

    /**
     *
     * @param dx [-1.0; 1.0]
     * @param dy [-1.0; 1.0]
     */
    public void rotate(double dx, double dy);

    public void scale(double value);

}
