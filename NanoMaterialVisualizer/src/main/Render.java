package main;

import java.awt.Color;
import main.geom.Shape;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * @author Alexey
 */
public class Render {

    private final BufferedImage buffer;
    private final Graphics graphics;
    private BufferedImage[] materials;
    private final int width;
    private final int heigth;
    private Shape shape;

    Render(Graphics graphics, int width, int height) {
        this.graphics = graphics;
        this.heigth = height;
        this.width = width;
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void loadImages() {
        try {
            materials = new BufferedImage[4];
            materials[0] = ImageIO.read(new File("images/Nanotube.jpg"));
            materials[1] = ImageIO.read(new File("images/fulleren.jpg"));
            materials[2] = ImageIO.read(new File("images/graphen.gif"));
            materials[3] = ImageIO.read(new File("images/crystal.jpg"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void display(File sourceFile) throws Exception {
        shape = ShapeLoader.load(sourceFile);
        update();
    }

    private void update() {        
        shape.draw(buffer.getGraphics(), width, heigth);        
        graphics.drawImage(buffer, 0, 0, null);
    }

    public void rotate(double dx, double dy) {
        dx /= width;
        dy /= heigth;
        shape.rotate(dx, dy);
        update();
    }

    public void scale(double value) {
        shape.scale(value);
        update();
    }

    public void visualize(int index) {
        if (index >= 0 || index < 4) {
            graphics.drawImage(materials[index], 0, 0, width, heigth, null);
        }
    }

}
