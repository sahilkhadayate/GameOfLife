package org.example;

public class Location {
    private final int xCoordinate;
    private final int yCoordinate;
    private final Cell cell = null;

    public Location(int xCoordinate, int yCoordinate) {
        if (xCoordinate<0 || yCoordinate<0) {
            throw new IllegalArgumentException();
        }
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

}
