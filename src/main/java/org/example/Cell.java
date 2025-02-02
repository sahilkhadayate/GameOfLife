package org.example;

public class Cell {
    private final int row;
    private final int column;
    private boolean isAlive;

    public Cell(int row, int column, boolean isAlive) {
        if(row <= -1 || column <= -1){
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.column = column;
        this.isAlive = isAlive;

    }

    public void updateCellState(int aliveNeighbours){
        throw new IllegalArgumentException();
    }

    public boolean isAlive() {
        return isAlive;
    }

}
