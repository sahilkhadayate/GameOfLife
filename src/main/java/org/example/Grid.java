package org.example;

import java.util.*;


//Allow for a command line interface to start a new run by specifying m & n and a percentage value for seeding. Start the Game Of Life by seeding a random population of cells in the specified percentage on the grid .
//On every tick of time, Present the Grid's state as output by modelling dead and alive cells as - & * s
//Continue until all cells are dead or user ends the simulation

public class Grid {
    private final int rows;
    private final int columns;
    private List<List<Location>> grid;

    public Grid(int rows, int columns){
        if(rows <= -1 || columns <= -1){
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.columns = columns;
        this.grid = new ArrayList<>();
    }

    public Grid(Grid other) {
        this.rows = other.rows;
        this.columns = other.columns;
        this.grid = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Location> newRow = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                Location original = other.grid.get(i).get(j);
          //      newRow.add(new Location(i,j, new Cell(false)));
            }
            this.grid.add(newRow);
        }
    }


    public void initializeGrid(double percentage){
        if(percentage < 1 || percentage > 100){
            throw new IllegalArgumentException();
        }
        int totalCells = rows * columns;
        int numberOfCellsToSeed = (int)(percentage * totalCells) / 100;

        Random random = new Random();
        Set<Integer> selectedCells = new HashSet<>();

        while (selectedCells.size() < numberOfCellsToSeed) {
            selectedCells.add(random.nextInt(totalCells));
        }

        for (int i = 0; i < rows; i++) {
            List<Location> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                int linearIndex = i*columns+j;
                boolean isAlive = selectedCells.contains(linearIndex);
           //     Location location = new Location(i,j, new Cell(isAlive));
                row.add(null);
            }
            grid.add(row);
        }

    }

    public void displayCurrentGridState(){
        if(this.grid.isEmpty()){
            throw new IllegalStateException();
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                Location location = this.grid.get(i).get(j);
                if(location.isAlive()){
                    System.out.print("* ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }


//    public void updateGrid() {
//        this.grid = buildUpdatedGrid();
//    }





//    public boolean canGridBeUpdatedFurther() {
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                Cell cell = getLocation( i, j );
//                int aliveNeighbours = calculateAliveNeighbours(i, j);
//                if (cell.determineNextState(aliveNeighbours) != cell.isAlive()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public Location getLocation(int xCoordinate, int yCoordinate) {
        if(xCoordinate < 0 || yCoordinate < 0){
            throw new IllegalArgumentException();
        }
        return this.grid.get(xCoordinate).get(yCoordinate);
    }


}

