package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class CellTest {

    @Test
    public void testCellCreationThrowsExceptionWhenRowIsNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 1,true));
    }

    @Test
    public void testCellCreationThrowsExceptionWhenColumnIsNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(1, -1,false));
    }

    @Test
    public void testCellCreationThrowsExceptionWhenBothRowAndColumnAreNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, -1,false));
    }

    @Test
    public void testCellCreatedWhenRowIs1AndColumnIs1(){
        Cell cell = new Cell(1, 1,false);
        assertNotNull(cell);
    }

    @Test
    public void testCellCreationThrowsExceptionWhenRowIs10AndColumnIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Cell(10, -1,true));
    }

    @Test
    public void testCellCreationThrowsExceptionWhenRowIsNegative10AndColumnIs10(){
        assertThrows(IllegalArgumentException.class, () -> new Cell(-10, 10,false));
    }

    @Test
    public void testCellIIsAliveReturnsFalseWhenCellIsNotAlive(){
      Cell cell =  new Cell(10, 10,false);
        boolean isAlive = cell.isAlive();
        assert(!isAlive);
    }

    @Test
    public void testUpdateCellStateThrowsExceptionWhenAliveNeighboursIsNegative1(){
        Cell cell =  new Cell(10, 10,false);
        assertThrows(IllegalArgumentException.class, () -> cell.updateCellState(-1));
    }

    @Test
    public void testUpdateCellStateThrowsExceptionWhenAliveNeighboursIsNegative3(){
        Cell cell =  new Cell(10, 10,false);
        assertThrows(IllegalArgumentException.class, () -> cell.updateCellState(-3));
    }
}
