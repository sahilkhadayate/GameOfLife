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
}
