package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testUpdateCellStateUpdatesItToAliveStateWhenAliveNeighboursAre2(){
        Cell cell =  new Cell(10, 10,true);
        cell.updateCellState(2);
        boolean isAlive = cell.isAlive();
        assertTrue(isAlive);
    }

    @Test
    public void testUpdateCellStateUpdatesItToAliveStateWhenAliveNeighboursAre3(){
        Cell cell =  new Cell(10, 10,true);
        cell.updateCellState(3);
        boolean isAlive = cell.isAlive();
        assertTrue(isAlive);
    }

    @Test
    public void testUpdateCellStateUpdatesItToNotAliveStateWhenAliveNeighboursAre0(){
        Cell cell =  new Cell(10, 10,true);
        cell.updateCellState(0);
        boolean isAlive = cell.isAlive();
        assertFalse(isAlive);
    }

    @Test
    public void testUpdateCellStateUpdatesItToNotAliveStateWhenAliveNeighboursAre1(){
        Cell cell =  new Cell(10, 10,true);
        cell.updateCellState(1);
        boolean isAlive = cell.isAlive();
        assertFalse(isAlive);
    }

    @Test
    public void testUpdateCellStateUpdatesItToNotAliveStateWhenAliveNeighboursAre4(){
        Cell cell =  new Cell(10, 10,true);
        cell.updateCellState(4);
        boolean isAlive = cell.isAlive();
        assertFalse(isAlive);
    }

    @Test
    public void testUpdateCellStateUpdatesItFromNotAliveToAliveStateWhenAliveNeighboursAre3(){
        Cell cell =  new Cell(10, 10,false);
        cell.updateCellState(3);
        boolean isAlive = cell.isAlive();
        assertTrue(isAlive);
    }
}
