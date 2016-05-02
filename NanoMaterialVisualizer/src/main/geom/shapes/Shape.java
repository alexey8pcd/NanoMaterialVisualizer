package main.geom.shapes;

import main.geom.Drawable;

/**
@author Alexey
 */
public interface Shape extends Drawable{

    /**
     *
     * @param dx [-1.0; 1.0]
     * @param dy [-1.0; 1.0]
     */
    public void rotate(double dx, double dy);

    public void scale(double value);

    public void translate(int dx, int dy);

}
