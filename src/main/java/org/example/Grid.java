package org.example;

import java.util.*;


//Allow for a command line interface to start a new run by specifying m & n and a percentage value for seeding. Start the Game Of Life by seeding a random population of cells in the specified percentage on the grid .
//On every tick of time, Present the Grid's state as output by modelling dead and alive cells as - & * s
//Continue until all cells are dead or user ends the simulation

public class Grid {

    private final int rows;
    private final int columns;
    private final Randomizer randomizer;
    private final List<List<Location>> grid;

    public Grid(int rows, int columns, Randomizer randomizer) {
        if(rows <= -1 || columns <= -1){
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.columns = columns;
        this.randomizer = randomizer;
        this.grid = new ArrayList<>();
    }


    public void initializeGrid(double percentage){
        if(percentage < 1 || percentage > 100){
            throw new IllegalArgumentException();
        }
        int totalCells = rows * columns;
        int numberOfCellsToSeed = (int)(percentage * totalCells) / 100;

        Set<Integer> selectedCells = new HashSet<>();

        while (selectedCells.size() < numberOfCellsToSeed) {
            selectedCells.add(randomizer.nextInt(totalCells));
        }

        for (int i = 0; i < rows; i++) {
            List<Location> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                int linearIndex = i*columns+j;
                boolean isAlive = selectedCells.contains(linearIndex);
                if (isAlive){
                    row.add(new Location(i,j,new Cell(),this::isLocationAlive));
                }
                else{
                    row.add(new Location(i,j,null,this::isLocationAlive));
                }
            }
            grid.add(row);
        }
    }

    public String displayCurrentGridState(){

        if(this.grid.isEmpty()){
            throw new IllegalStateException();
        }
        StringBuilder state = new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                Location location = this.grid.get(i).get(j);
                state.append(location.isAlive() ? "* " : "- ");
                if (location.isAlive()) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }

            }
            System.out.println();
        }
        return state.toString();
    }

    private boolean isLocationAlive(int xCoordinate, int yCoordinate){
            return isInsideBounds(xCoordinate,yCoordinate) && getLocation(xCoordinate,yCoordinate).isAlive();
    }

    private boolean isInsideBounds(int xCoordinate, int yCoordinate){
        return xCoordinate >= 0 && yCoordinate >= 0 && xCoordinate < rows && yCoordinate < columns;
    }

    public void updateGrid() {
        for(List<Location> locations: grid){
            for(Location location: locations){
                location.prepareNextState();
            }
        }
        for(List<Location> locations: grid){
            for(Location location: locations){
                location.update();
            }
        }

    }

    public Location getLocation(int xCoordinate, int yCoordinate) {
        if(xCoordinate < 0 || yCoordinate < 0){
            throw new IllegalArgumentException();
        }
        return this.grid.get(xCoordinate).get(yCoordinate);
    }


}

