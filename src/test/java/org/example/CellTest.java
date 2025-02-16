package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {


    @Test
    public void testCellCreation(){
        Cell cell = new Cell();
        assertNotNull(cell);
    }

//
//    @Test
//    public void testCellIIsAliveReturnsFalseWhenCellIsNotAlive(){
//      Cell cell =  new Cell(false);
//        boolean isAlive = cell.isAlive();
//        assert(!isAlive);
//    }


//    @Test
//    public void testUpdateCellStateThrowsExceptionWhenAliveNeighboursIsNegative1(){
//        Cell cell =  new Cell(false);
//        assertThrows(IllegalArgumentException.class, () -> cell.determineNextState(-1));
//    }

//    @Test
//    public void testUpdateCellStateThrowsExceptionWhenAliveNeighboursIsNegative3(){
//        Cell cell =  new Cell(false);
//        assertThrows(IllegalArgumentException.class, () -> cell.determineNextState(-3));
//    }
//
//    @Test
//    public void testUpdateCellStateUpdatesItToAliveStateWhenAliveNeighboursAre2(){
//        Cell cell =  new Cell(true);
//
//
//        assertTrue(cell.determineNextState(2));
//    }
//
//    @Test
//    public void testUpdateCellStateUpdatesItToAliveStateWhenAliveNeighboursAre3(){
//        Cell cell =  new Cell(true);
//        cell.determineNextState(3);
//        boolean isAlive = cell.determineNextState(3);
//
//        assertTrue(isAlive);
//    }
//
//    @Test
//    public void testUpdateCellStateUpdatesItToNotAliveStateWhenAliveNeighboursAre0(){
//        Cell cell =  new Cell(true);
//
//        boolean isAlive = cell.determineNextState(0);
//        assertFalse(isAlive);
//    }
//
//    @Test
//    public void testUpdateCellStateUpdatesItToNotAliveStateWhenAliveNeighboursAre1(){
//        Cell cell =  new Cell(true);
//        boolean isAlive =        cell.determineNextState(1);
//
//        assertFalse(isAlive);
//    }
//
//    @Test
//    public void testUpdateCellStateUpdatesItToNotAliveStateWhenAliveNeighboursAre4(){
//        Cell cell =  new Cell(true);
//        boolean isAlive =         cell.determineNextState(4);
//
//        assertFalse(isAlive);
//    }
//
//    @Test
//    public void testUpdateCellStateUpdatesItFromNotAliveToAliveStateWhenAliveNeighboursAre3(){
//        Cell cell =  new Cell(false);
//        cell.determineNextState(3);
//        boolean isAlive =         cell.determineNextState(3);
//
//        assertTrue(isAlive);
//    }

}
