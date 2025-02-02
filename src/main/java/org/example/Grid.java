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

    public void seedGrid(int percentage){
        if(percentage < 1){
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
        return grid.get(x_coordinate).get(y_coordinate);
    }
}
