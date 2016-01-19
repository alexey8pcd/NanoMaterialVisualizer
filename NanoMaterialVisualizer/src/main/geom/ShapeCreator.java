package main.geom;

import main.geom.creators.FullerenCreator;
import main.geom.creators.GraphenCreator;
import main.geom.creators.NanocrystalCreator;
import main.geom.creators.NanotubeCreator;

/**
 * @author Alexey
 */
public class ShapeCreator {

    private void createNanotube() {
        new NanotubeCreator().create();
    }

    public ShapeCreator() {

    }

    public void createGraphen() {
        new GraphenCreator().create();
    }

    public void createFulleren() {
        new FullerenCreator().create();
    }

    public void createNanocrystal() {
        new NanocrystalCreator().create();
    }

    public static void main(String[] args) {
        ShapeCreator shapeCreator = new ShapeCreator();
        shapeCreator.createNanotube();
        shapeCreator.createGraphen();
        shapeCreator.createFulleren();
        shapeCreator.createNanocrystal();
    }
}
