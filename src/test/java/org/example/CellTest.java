package org.example;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class CellTest {

    @Test
    public void testCellCreationThrowsExceptionWhenRowIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 1));
    }
}
