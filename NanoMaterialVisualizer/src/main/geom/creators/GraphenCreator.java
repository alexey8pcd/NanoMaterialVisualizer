package main.geom.creators;

import java.util.ArrayList;
import java.util.List;
import main.geom.Vertex3F;

/**
 * @author Alexey
 */
public class GraphenCreator {

    private final int pointsHorizontal = 20;
    private final int pointsVertical = 20;
    private List<List<Vertex3F>> vertexes;

    public GraphenCreator() {
        vertexes = new ArrayList<>(pointsVertical);
    }

    public void create() {
        int startX = 50;
        int startY = 50;
        int dx = 50;
        int dx2 = dx * 2;
        int dz = 20;
        float y = startY;
        float x;
        float z = 0;
        for (int j = 0; j < pointsVertical; j++) {
            if (j % 2 == 0) {
                x = startX;
            } else {
                x = dx * 3 / 2;
            }
            List<Vertex3F> row = new ArrayList<>(pointsHorizontal);
            for (int i = 0; i < pointsHorizontal; i++) {
                row.add(new Vertex3F(x, y, z));
                if (i % 2 == 0) {
                    x += dx;
                } else {
                    x += dx2;
                }
            }
            vertexes.add(row);
            z += dz;
        }

    }

}
