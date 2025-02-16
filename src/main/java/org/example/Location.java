package org.example;

public class Location {
    private final int xCoordinate;
    private final int yCoordinate;
    private final NeighbourChecker neighbourChecker;
    private Cell cell = null;


    public Location(int xCoordinate, int yCoordinate, Cell cell, NeighbourChecker neighbourChecker) {
        if (xCoordinate<0 || yCoordinate<0) {
            throw new IllegalArgumentException();
        }
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.cell = cell;
        this.neighbourChecker = neighbourChecker;
    }


    private boolean determineNextState(int aliveNeighbours) {
        if (aliveNeighbours < 0) {
            throw new IllegalArgumentException();
        }
        if (isAlive()) {
            return aliveNeighbours == 2 || aliveNeighbours == 3;
        } else {
            return aliveNeighbours == 3;
        }
    }

    public boolean isAlive() {
        return cell != null;
    }

}
