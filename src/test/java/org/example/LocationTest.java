package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

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
}
