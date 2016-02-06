package main.geom.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main.geom.PrimitiveBuilder;
import main.geom.Vertex3F;
import main.geom.shapes.Fulleren;
import main.geom.shapes.HexagoneShape;
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
            case FULLEREN:
                return loadFulleren(new File(SOURCES[1]));
            case GRAPHEN:
                return loadGraphen(new File(SOURCES[2]));
            case NANOCRYSTAL:
                break;
        }
        return null;
    }

    private static HexagoneShape loadNanotube(File sourceFile) throws Exception {
        HexagoneShape nanotube;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            nanotube = new HexagoneShape();
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

    private static Shape loadGraphen(File sourceFile) throws IOException {
        HexagoneShape graphen;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            graphen = new HexagoneShape();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.startsWith(COMMENT_PREFIX)) {
                    graphen.addHexagone(PrimitiveBuilder.createHexagone(line));
                }
            }
        }
        return graphen;
    }

}
