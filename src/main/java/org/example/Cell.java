package org.example;

public class Cell {

    private final boolean isAlive;

    public Cell( boolean isAlive) {
        this.isAlive = isAlive;

    }


    public boolean determineNextState(int aliveNeighbours) {
        if (aliveNeighbours < 0) {
            throw new IllegalArgumentException();
        }
        if (this.isAlive()) {
            return aliveNeighbours == 2 || aliveNeighbours == 3;
        } else {
            return aliveNeighbours == 3;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

}
