package main.geom;

/**
 * @author Alexey
 */
public class DisplayProperties {

    private static int width;
    private static int height;
    private static int xPos;
    private static int yPos;

    public static void setDefaultDisplayProperties(int width, int height) {
        DisplayProperties.width = width;
        DisplayProperties.height = height;
        reset();
    }

    public static int getXPos() {
        return xPos;
    }

    public static int getYPos() {
        return yPos;
    }

    public static void changeXPos(int dx) {
        xPos += dx;
    }

    public static void changeYPos(int dy) {
        yPos += dy;
    }

    public static void reset() {
        xPos = width / 4;
        yPos = height - height / 4;
    }

}
