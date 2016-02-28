package main.geom.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import main.geom.primitive.PrimitiveBuilder;
import main.geom.Vertex3F;

/**
 * @author Alexey
 */
public final class ShapeLoader {

    private ShapeLoader() {

    }

    private static final String[] SOURCES = {
        "nanotube.txt",
        "fulleren.txt",
        "graphen.txt",
        "nanocrystal.txt"
    };
    private static final String COMMENT_PREFIX = "--";

    public static Shape loadShape(ShapeType shapeType) throws Exception {
        switch (shapeType) {
            case NANOTUBE:
                return loadHexagoneShape(new File(SOURCES[0]));
            case FULLEREN:
                return loadFulleren(new File(SOURCES[1]));
            case GRAPHEN:
                return loadHexagoneShape(new File(SOURCES[2]));
            case NANOCRYSTAL:
                return loadTriangleShape(new File(SOURCES[3]));
        }
        return null;
    }
   
    private static Shape loadHexagoneShape(File sourceFile) throws IOException {
        BaseShape hexagoneShape;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            hexagoneShape = new BaseShape();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.startsWith(COMMENT_PREFIX)) {
                    hexagoneShape.addPrimitive(PrimitiveBuilder.createHexagone(line));
                }
            }
        }
        return hexagoneShape;
    }

    private static Shape loadFulleren(File sourceFile) throws Exception {
        Fulleren fulleren;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            fulleren = new Fulleren();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.startsWith(COMMENT_PREFIX)) {
                    fulleren.addVertex(createVertex(line));
                }
            }
        }
        fulleren.build();
        for (int i = 0; i < 15; i++) {
            fulleren.scale(Integer.MAX_VALUE);
        }
        return fulleren;
    }

    private static Vertex3F createVertex(String point) {
        String[] coordinates = point.trim().split(";");
        float x = Float.parseFloat(coordinates[0]);
        float y = Float.parseFloat(coordinates[1]);
        float z = Float.parseFloat(coordinates[2]);
        Vertex3F vertex3F = new Vertex3F(x, y, z);
        return vertex3F;
    }    

    private static Shape loadTriangleShape(File sourceFile) throws IOException {
        BaseShape crystal;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            crystal = new BaseShape();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.startsWith(COMMENT_PREFIX)) {
                    crystal.addPrimitive(PrimitiveBuilder.createTriangle(line));
                }
            }
        }
        return crystal;
    }

}
