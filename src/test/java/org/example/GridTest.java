package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void testGridCreationThrowsExceptionWhenRowIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 1));
    }

    @Test
    public void testGridCreationThrowsExceptionWhenColumnIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(1, -1));
    }

    @Test
    public void testGridCreationThrowsExceptionWhenColumnAndRowIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, -1));
    }
    @Test
    public void testGridCreationThrowsExceptionWhenColumnIs10AndRowIsNegative10(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(10, -1));
    }

    @Test
    public void testGridCreatedWhenRowIs1AndColumnIs1(){
        Grid grid = new Grid(1, 1);
        assertNotNull(grid);
    }
    @Test
    public void testGridThrowsExceptionWhenPercentageIsNegative1(){
        Grid grid  = new Grid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> grid.initializeGrid(-1));
    }

    @Test
    public void testGridThrowsExceptionWhenPercentageIsNegative3(){
        Grid grid  = new Grid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> grid.initializeGrid(-3));
    }

    @Test
    public void testInitializeGridWith10Percent(){
    Grid grid = new Grid(3,3);
    grid.initializeGrid(10);
    }

    @Test
    public void testCellsInGridAreNonNull(){
        Grid grid = new Grid(3,3);
        grid.initializeGrid(10);

    }

    @Test
    public void test7CellsAreAliveInGridAreAliveWhenPercentageIs30And5x5Grid(){
        Grid grid = new Grid(5,5);
        grid.initializeGrid(30);
        int count = 0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(grid.getLocation(i,j).isAlive()){
                    count++;
                }
            }
        }
        grid.displayCurrentGridState();
        assertEquals(7,count);
    }

    @Test
    public void testUpdateGridStateChangesStateOfGridAfterOneIteration(){
        Grid grid = new Grid(5,5);
        grid.initializeGrid(30);
        Grid initialGrid = new Grid(grid);
        grid.displayCurrentGridState();
        grid.updateGrid();
        grid.displayCurrentGridState();
        assertNotEquals(initialGrid, grid);
    }


}
