package org.example;

import java.util.List;

public class Grid {
    private final int rows;
    private final int columns;

    public Grid(int rows, int columns){
        if(rows <= -1 || columns == -1){
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.columns = columns;
    }
}
