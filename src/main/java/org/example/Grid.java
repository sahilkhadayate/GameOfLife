package org.example;

import java.util.*;


//Allow for a command line interface to start a new run by specifying m & n and a percentage value for seeding. Start the Game Of Life by seeding a random population of cells in the specified percentage on the grid .
//On every tick of time, Present the Grid's state as output by modelling dead and alive cells as - & * s
//Continue until all cells are dead or user ends the simulation

public class Grid {
    public static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private final int rows;
    private final int columns;
    private List<List<Cell>> grid;

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
            List<Cell> newRow = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                Cell original = other.grid.get(i).get(j);
                newRow.add(new Cell(original.isAlive()));
            }
            this.grid.add(newRow);
        }
    }


    public void seedGrid(double percentage){
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
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                int linearIndex = i*columns+j;
                boolean isAlive = selectedCells.contains(linearIndex);
                Cell cell = new Cell(isAlive);
                row.add(cell);
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
                Cell cell = this.grid.get(i).get(j);
                if(cell.isAlive()){
                    System.out.print("* ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public void updateGrid() {
        this.grid = buildUpdatedGrid();
    }

    private List<List<Cell>> buildUpdatedGrid() {
        List<List<Cell>> newGrid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            newGrid.add(buildUpdatedRow(i));
        }
        return newGrid;
    }

    private List<Cell> buildUpdatedRow(int rowIndex) {
        List<Cell> newRow = new ArrayList<>();
        for (int j = 0; j < columns; j++) {
            newRow.add(updateCell(rowIndex, j));
        }
        return newRow;
    }

    private Cell updateCell(int rowIndex, int columnIndex) {
        Cell cell = getCell(rowIndex, columnIndex);
        int aliveNeighbours = calculateAliveNeighbours(rowIndex, columnIndex);
        boolean nextState = cell.determineNextState(aliveNeighbours);
        return new Cell(nextState);
    }



    private int calculateAliveNeighbours(int xCoordinate, int yCoordinate){
        int aliveNeighbours = 0;
        for(int[] direction: DIRECTIONS){
            int newXCoordinate = xCoordinate+direction[0];
            int newYCoordinate = yCoordinate+direction[1];
            if(newXCoordinate >= 0 && newXCoordinate < rows && newYCoordinate >= 0 && newYCoordinate < columns){
               Cell neighbouringCell = getCell(newXCoordinate, newYCoordinate);
                if(neighbouringCell.isAlive()){
                     aliveNeighbours++;
                }
            }
        }
return aliveNeighbours;
    }


    public boolean canGridBeUpdatedFurther() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = getCell( i, j );
                int aliveNeighbours = calculateAliveNeighbours(i, j);
                if (cell.determineNextState(aliveNeighbours) != cell.isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }
    public Cell getCell(int xCoordinate, int yCoordinate) {
        if(xCoordinate < 0 || yCoordinate < 0){
            throw new IllegalArgumentException();
        }
        return this.grid.get(xCoordinate).get(yCoordinate);
    }


}

