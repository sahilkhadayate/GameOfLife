package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> grid.seedGrid(-1));
    }

    @Test
    public void testGridThrowsExceptionWhenPercentageIsNegative3(){
        Grid grid  = new Grid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> grid.seedGrid(-3));
    }

    @Test
    public void testSeedGridWith10Percent(){
    Grid grid = new Grid(3,3);
    grid.seedGrid(10);
    }
}
