package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import main.geom.PrimitiveBuilder;
import main.geom.Vertex3F;
import main.geom.shapes.Fulleren;
import main.geom.shapes.Nanotube;
import main.geom.shapes.Shape;
import main.geom.shapes.ShapeType;

/**
 * @author Alexey
 */
public class ShapeLoader {

    private static final String[] SOURCES = {
        "nanotube.txt",
        "raw_fulleren",
        "graphen.txt",
        "nanocrystal.txt"
    };
    private static final String COMMENT_PREFIX = "--";

    public static Shape loadShape(ShapeType shapeType) throws Exception {
        switch (shapeType) {
            case NANOTUBE:
                return loadNanotube(new File(SOURCES[0]));
            case GRAPHEN:
                break;
            case FULLEREN:
                return loadFulleren(new File(SOURCES[1]));
            case NANOCRYSTAL:
                break;
        }
        return null;
    }

    private static Nanotube loadNanotube(File sourceFile) throws Exception {
        Nanotube nanotube;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            nanotube = new Nanotube();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.startsWith(COMMENT_PREFIX)) {
                    nanotube.addHexagone(PrimitiveBuilder.createHexagone(line));
                }
            }
        }
        return nanotube;
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

}
