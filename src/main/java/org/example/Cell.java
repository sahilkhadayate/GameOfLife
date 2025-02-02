package org.example;

public class Cell {
    private final int row;
    private final int column;
    private boolean isAlive;

    public Cell(int row, int column) {
        if(row == -1 || column <= -1){
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.column = column;
    }
}
