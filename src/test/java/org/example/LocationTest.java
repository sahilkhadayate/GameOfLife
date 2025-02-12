package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class LocationTest {


    @Test
    public void testLocationCreationWithNegative1xCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(-1,0));
    }

    @Test
    public void testLocationCreationWithNegative3xCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(-3,0));
    }
    @Test
    public void testLocationCreationWithNegative3yCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(3,-3));
    }

@Test
    public void testLocationCreationWithNegative1yCoordinate() {
        assertThrows(IllegalArgumentException.class ,()->new Location(3,-1));
    }


    @Test
    public void testLocationCreationWithPositiveCoordinates() {
        Location location = new Location(1,0);
        assertNotNull(location);
    }
}
