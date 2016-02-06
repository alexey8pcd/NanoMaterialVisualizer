package main;

import main.geom.shapes.ShapeLoader;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.geom.shapes.Shape;
import main.geom.shapes.ShapeType;

/**
 * @author Alexey
 */
public class Render {

    private final BufferedImage buffer;
    private final Graphics graphics;
    private final int width;
    private final int heigth;
    private Shape shape;

    Render(Graphics graphics, int width, int height) {
        this.graphics = graphics;
        this.heigth = height;
        this.width = width;
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void display(ShapeType shapeType) throws Exception {
        shape = ShapeLoader.loadShape(shapeType);
        update();
    }

    private void update() {
        shape.draw(buffer.getGraphics(), width, heigth);
        graphics.drawImage(buffer, 0, 0, null);
    }

    public void rotate(double dx, double dy) {
        if (shape != null) {
            if (Math.abs(dx) > width) {
                dx = width * Math.signum(dx);
            }
            if (Math.abs(dy) > heigth) {
                dy = heigth * Math.signum(dy);
            }
            dx /= 2 * width;
            dy /= 2 * heigth;
            shape.rotate(dx, dy);
            update();
        }
    }

    public void scale(double value) {
        shape.scale(value);
        update();
    }

}
