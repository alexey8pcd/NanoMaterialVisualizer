package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * @author Alexey
 */
public class Render {

    private final BufferedImage image;
    private final Graphics graphics;
    private BufferedImage[] materials;
    private final int width;
    private final int heigth;

    Render(Graphics graphics, int width, int height) {
        this.graphics = graphics;
        this.heigth = height;
        this.width = width;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

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

    void visualize(int index) {
        if (index >= 0 || index < 4) {
            graphics.drawImage(materials[index], 0, 0, width, heigth, null);
        }
    }

}
