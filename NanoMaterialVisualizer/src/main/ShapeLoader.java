package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import main.geom.HexagonBuilder;
import main.geom.Shape;

/**
 * @author Alexey
 */
public class ShapeLoader {

    public static Shape load(File sourceFile) throws Exception {
        Shape shape;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            shape = new Shape();
            while (bufferedReader.ready()) {
                shape.addHexagone(HexagonBuilder.create(bufferedReader.readLine()));
            }
        }
        return shape;
    }

}
