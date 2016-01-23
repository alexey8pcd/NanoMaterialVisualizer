package main.geom.shapes;

public enum ShapeType {

    NANOTUBE(0),
    FULLEREN(1),
    GRAPHEN(2),
    NANOCRYSTAL(3);

    private final int index;

    private ShapeType(int index) {
        this.index = index;
    }

    public static ShapeType getBy(int index) {
        ShapeType[] values = ShapeType.values();
        for (ShapeType shapeType : values) {
            if (shapeType.index == index) {
                return shapeType;
            }
        }
        return values[0];
    }

}
