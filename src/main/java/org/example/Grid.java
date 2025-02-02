package org.example;

import java.util.List;


//Allow for a command line interface to start a new run by specifying m & n and a percentage value for seeding. Start the Game Of Life by seeding a random population of cells in the specified percentage on the grid .
//On every tick of time, Present the Grid's state as output by modelling dead and alive cells as - & * s
//Continue until all cells are dead or user ends the simulation

public class Grid {
    private final int rows;
    private final int columns;

    public Grid(int rows, int columns, int percentage){
        if(rows <= -1 || columns <= -1 || percentage < 1){
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.columns = columns;
        seedGrid(percentage);
    }

    private void seedGrid(int percentage){

    }
}
