package main.geom;

/**
 * @author Alexey
 */
public abstract class HexagonBuilder {

    /**
     *
     * @param coordinatesLine - строка вида x1;y1;z1, x2;y2;z2,..., x5;y5;z5
     * @return
     */
    public static final Hexagone create(String coordinatesLine) {
        String[] points = coordinatesLine.split(",");
        Hexagone hexagone = new Hexagone();
        for (int i = 0; i < Hexagone.EDGE_COUNT; i++) {
            hexagone.setVertex(createVertex(points[i]), i);
        }
        return hexagone;
    }

    private static Vertex3F createVertex(String point) {
        String[] coordinates = point.trim().split(";");
        float x = Float.parseFloat(coordinates[0]);
        float y = Float.parseFloat(coordinates[1]);
        float z = Float.parseFloat(coordinates[2]);
        Vertex3F vertex3F = new Vertex3F(x, y, z);
        return vertex3F;
    }
}
