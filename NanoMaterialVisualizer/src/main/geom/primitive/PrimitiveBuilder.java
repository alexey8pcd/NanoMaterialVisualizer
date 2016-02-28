package main.geom.primitive;

import main.geom.Vertex3F;

/**
 * @author Alexey
 */
public final class PrimitiveBuilder {
    
    private PrimitiveBuilder(){
        
    }

    /**
     *
     * @param coordinatesLine - строка вида x1;y1;z1, x2;y2;z2,..., x5;y5;z5
     * @return
     */
    public static final GeometricPrimitive createHexagone(String coordinatesLine) {
        int vertexes = 6;
        int edges = 6;
        return createPrimitive(coordinatesLine, edges, vertexes);
    }

    public static final GeometricPrimitive createPentagone(String coordinatesLine) {
        int vertexes = 5;
        int edges = 5;
        return createPrimitive(coordinatesLine, edges, vertexes);
    }
    
    public static final GeometricPrimitive createTriangle(String coordinatesLine){
        int vertexes = 3;
        int edges = 3;
        return createPrimitive(coordinatesLine, edges, vertexes);
    }

    private static GeometricPrimitive createPrimitive(String coordinatesLine, int edges, int vertexes) {
        String[] points = coordinatesLine.replace("[", "").replace("]", "").split(",");
        Primitive3D primitive = new Primitive3D(edges, vertexes);
        for (int i = 0; i < vertexes; i++) {
            primitive.setVertex(createVertex(points[i]), i);
        }
        return primitive;
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
