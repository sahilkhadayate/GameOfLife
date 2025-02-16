package org.example;


public class Location {
    private final int [][]DIRECTIONS = {{1,1},{1,0},{0,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
    private final int xCoordinate;
    private final int yCoordinate;
    private final NeighbourChecker neighbourChecker;
    private Cell cell;


    public Location(int xCoordinate, int yCoordinate, Cell cell, NeighbourChecker neighbourChecker) {
        if (xCoordinate<0 || yCoordinate<0) {
            throw new IllegalArgumentException();
        }
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.cell = cell;
        this.neighbourChecker = neighbourChecker;
    }

    public void update() {
            if (determineNextState()){
                this.cell = new Cell();
            }
            else{
                this.cell =null;
            }

    }

    public boolean isAlive() {
        return cell != null;
    }

    private boolean determineNextState() {
        int aliveNeighbours = fetchAliveNeighbours();
        if (aliveNeighbours < 0) {
            throw new IllegalArgumentException();
        }
        if (this.isAlive()) {
            return aliveNeighbours == 2 || aliveNeighbours == 3;
        }
        else {
            return aliveNeighbours == 3;
        }
    }

    private int fetchAliveNeighbours(){
       int aliveNeighbours=0;
        for (int[] dir:DIRECTIONS){
            int newX = this.xCoordinate+dir[0];
            int newY = this.yCoordinate+dir[1];
            if(this.neighbourChecker.isNeighbourAlive(newX,newY)){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }


}
