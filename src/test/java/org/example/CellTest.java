package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class CellTest {

    @Test
    public void testCellCreationThrowsExceptionWhenRowIsNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 1));
    }

    @Test
    public void testCellCreationThrowsExceptionWhenColumnIsNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(1, -1));
    }

    @Test
    public void testCellCreationThrowsExceptionWhenBothRowAndColumnAreNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, -1));
    }

    @Test
    public void testCellCreatedWhenRowAndColumnArePositive(){
        Cell cell = new Cell(1, 1);
        assertNotNull(cell);
    }
}
