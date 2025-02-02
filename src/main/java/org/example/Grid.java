package org.example;

import java.util.*;


//Allow for a command line interface to start a new run by specifying m & n and a percentage value for seeding. Start the Game Of Life by seeding a random population of cells in the specified percentage on the grid .
//On every tick of time, Present the Grid's state as output by modelling dead and alive cells as - & * s
//Continue until all cells are dead or user ends the simulation

public class Grid {
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
                newRow.add(new Cell(i,j, original.isAlive()));
            }
            this.grid.add(newRow);
        }
    }


    public void seedGrid(int percentage){
        if(percentage < 1 || percentage > 100){
            throw new IllegalArgumentException();
        }
        int totalCells = rows * columns;
        int numberOfCellsToSeed = (percentage * totalCells) / 100;

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
                row.add(new Cell(i, j,isAlive));
            }
            grid.add(row);
        }

    }

    public Cell getCell(int x_coordinate, int y_coordinate) {
        if(x_coordinate < 0 || y_coordinate < 0){
            throw new IllegalArgumentException();
        }
        return this.grid.get(x_coordinate).get(y_coordinate);
    }

    public void printCurrentGridState(){
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grid grid = (Grid) obj;
        if (this.rows != grid.rows || this.columns != grid.columns) {
            return false;
        }

        return this.grid.equals(grid.grid);
    }
    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, grid);
    }


    public void updateGrid(){
        List<List<Cell>> newGrid = new ArrayList<>();
        for(int i=0;i<rows;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<columns;j++){
                Cell cell = this.grid.get(i).get(j);
                int aliveNeighbours = calculateAliveNeighbours(i, j);
                boolean nextState = cell.determineNextState(aliveNeighbours);
                row.add(new Cell(i, j, nextState));
            }
            newGrid.add(row);
        }
        this.grid = newGrid;
    }

    private int calculateAliveNeighbours(int x, int y){
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int aliveNeighbours = 0;
        for(int[] direction: directions){
            int newX = x+direction[0];
            int newY = y+direction[1];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < columns){
               Cell neighbouringCell = this.grid.get(newX).get(newY);
                if(neighbouringCell.isAlive()){
                     aliveNeighbours++;
                }
            }
        }
return aliveNeighbours;
    }


    public boolean canUpdateGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = this.grid.get(i).get(j);
                int aliveNeighbours = calculateAliveNeighbours(i, j);
                if (cell.determineNextState(aliveNeighbours) != cell.isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }
}
