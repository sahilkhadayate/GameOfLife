package org.example;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LocationTest {

    private NeighbourChecker neighbourChecker;

    @Test
    public void testLocationCreationWithNegative1xCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(-1,0, new Cell(),neighbourChecker));
    }

    @Test
    public void testLocationCreationWithNegative3xCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(-3,0, new Cell(),neighbourChecker));
    }
    @Test
    public void testLocationCreationWithNegative3yCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(3,-3, new Cell(),neighbourChecker));
    }

@Test
    public void testLocationCreationWithNegative1yCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(3,-1, new Cell(),neighbourChecker));
    }


    @Test
    public void testLocationCreationWithPositiveCoordinates() {
        Location location = new Location(1,0, new Cell(),neighbourChecker);
        assertNotNull(location);
    }

    @Test
    public void testLocationIsNotAliveAndProvidesItIsNotAlive(){
        Location location = new Location(1,1,null,neighbourChecker);
        assertFalse(location.isAlive());
    }

    @Test
    public void testLocationIsAliveAndProvidesItIsAlive(){
        Location location = new Location(1,1,new Cell(),neighbourChecker);
        assertTrue(location.isAlive());
    }
    @Test
    public void testLocationStaysAliveWhenAliveNeighboursAre2(){
        NeighbourChecker neighbourChecker1 = mock(NeighbourChecker.class);
        when(neighbourChecker1.isNeighbourAlive(anyInt(), anyInt())).thenAnswer(invocation -> {
            int x = invocation.getArgument(0);
            int y = invocation.getArgument(1);
            return (x == 1 && y == 0) || (x == 2 && y == 1);
        });


        Location location = new Location(1,1,new Cell(), neighbourChecker1);
        location.update();
        assertTrue(location.isAlive());
    }


    @Test
    public void testLocationDiesWhenAliveNeighboursAre1(){

        NeighbourChecker neighbourChecker1 = mock(NeighbourChecker.class);
        when(neighbourChecker1.isNeighbourAlive(anyInt(), anyInt())).thenAnswer(invocation -> {
            int x = invocation.getArgument(0);
            int y = invocation.getArgument(1);
            return (x == 2 && y == 1);
        });

        Location location = new Location(1,1,new Cell(), neighbourChecker1);
        location.update();
        assertFalse(location.isAlive());
    }

    @Test
    public void testLocationDiesWhenAliveNeighboursAre4(){

        NeighbourChecker neighbourChecker1 = mock(NeighbourChecker.class);
        when(neighbourChecker1.isNeighbourAlive(anyInt(), anyInt())).thenAnswer(invocation -> {
            int x = invocation.getArgument(0);
            int y = invocation.getArgument(1);
            return (x == 2 && y == 1) || (x == 0 && y == 1) || (x == 1 && y == 0) || (x == 1 && y == 2) ;
        });

        Location location = new Location(1,1,new Cell(), neighbourChecker1);
        location.update();
        assertFalse(location.isAlive());
    }

    @Test
    public void testLocationComesAliveWhenAliveNeighboursAre3(){

        NeighbourChecker neighbourChecker1 = mock(NeighbourChecker.class);
        when(neighbourChecker1.isNeighbourAlive(anyInt(), anyInt())).thenAnswer(invocation -> {
            int x = invocation.getArgument(0);
            int y = invocation.getArgument(1);
            return (x == 2 && y == 1) || (x == 0 && y == 1) || (x == 1 && y == 0) ;
        });

        Location location = new Location(1,1,null, neighbourChecker1);
        location.update();
        assertTrue(location.isAlive());
    }
}
