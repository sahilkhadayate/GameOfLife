package org.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GridTest {

    @Test
    public void testGridCreationThrowsExceptionWhenRowIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 1,new Randomizer()));
    }

    @Test
    public void testGridCreationThrowsExceptionWhenColumnIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(1, -1,new Randomizer()));
    }

    @Test
    public void testGridCreationThrowsExceptionWhenColumnAndRowIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, -1,new Randomizer()));
    }
    @Test
    public void testGridCreationThrowsExceptionWhenColumnIs10AndRowIsNegative10(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(10, -1,new Randomizer()));
    }

    @Test
    public void testGridCreatedWhenRowIs1AndColumnIs1(){
        Grid grid = new Grid(1, 1,new Randomizer());
        assertNotNull(grid);
    }
    @Test
    public void testGridThrowsExceptionWhenPercentageIsNegative1(){
        Grid grid  = new Grid(10, 10,new Randomizer());
        assertThrows(IllegalArgumentException.class, () -> grid.initializeGrid(-1));
    }

    @Test
    public void testGridThrowsExceptionWhenPercentageIsNegative3(){
        Grid grid  = new Grid(10, 10,new Randomizer());
        assertThrows(IllegalArgumentException.class, () -> grid.initializeGrid(-3));
    }

    @Test
    public void testInitializeGridWith10Percent(){
    Grid grid = new Grid(3,3,new Randomizer());
    grid.initializeGrid(10);
    }

    @Test
    public void testCellsInGridAreNonNull(){
        Grid grid = new Grid(3,3,new Randomizer());
        grid.initializeGrid(10);

    }

    @Test
    public void test7CellsAreAliveInGridAreAliveWhenPercentageIs30And5x5Grid(){
        Grid grid = new Grid(5,5,new Randomizer());
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
    public void testUpdateGridStateChangesStateOfGridAfterOneIteration() {
        Grid grid = new Grid(5, 5,new Randomizer());
        grid.initializeGrid(30);

        // Capture initial grid state
        ByteArrayOutputStream initialOutput = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(initialOutput));
        grid.displayCurrentGridState();
        System.setOut(originalOut);

        String initialState = initialOutput.toString();

        // Update grid state
        grid.updateGrid();

        // Capture updated grid state
        ByteArrayOutputStream updatedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(updatedOutput));
        grid.displayCurrentGridState();
        System.setOut(originalOut);

        String updatedState = updatedOutput.toString();

        // Assert that the grid state has changed after update
        assertNotEquals(initialState, updatedState);
    }

    @Test
    public void test5X5GridWith10percentSeedingUpdateAfter1Iteration() {
        Randomizer mockRandomizer = mock(Randomizer.class);

        when(mockRandomizer.nextInt(25)).thenReturn(3, 7, 10, 12, 16);
        Grid grid = new Grid(5, 5,mockRandomizer);
        grid.initializeGrid(20);
        grid.displayCurrentGridState();
        grid.updateGrid();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        grid.displayCurrentGridState();
        System.setOut(System.out);


        String expectedState = "- - - - - \n" + "- * * * - \n" + "- - * - - \n" + "- * - - - \n" + "- - - - - \n";

        assertEquals(expectedState, outputStream.toString());
    }

    @Test
    public void test10X10GridWith10percentSeedingUpdateAfter1Iteration() {
        Randomizer mockRandomizer = mock(Randomizer.class);

        when(mockRandomizer.nextInt(100)).thenReturn(5, 12, 24, 33, 47, 52, 65, 72, 84, 91);

        Grid grid = new Grid(10, 10, mockRandomizer);
        grid.initializeGrid(10); // 10% seeding
        grid.displayCurrentGridState();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        grid.displayCurrentGridState();
        System.setOut(System.out);
        String initialState = outputStream.toString();

        grid.updateGrid();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        grid.displayCurrentGridState();
        System.setOut(System.out);
        String updatedState = outputStream.toString();

        String expectedState =
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - * - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n" +
                        "- - - - - - - - - - \n";

        assertEquals(expectedState, updatedState);
    }


}
