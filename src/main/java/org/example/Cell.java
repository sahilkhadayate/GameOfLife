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


    public boolean determineNextState(int aliveNeighbours) {
if(aliveNeighbours<0){
    throw new IllegalArgumentException();
}
        if(this.isAlive()){
            return aliveNeighbours == 2 || aliveNeighbours == 3;
        }
        else{
            return aliveNeighbours == 3;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

}
