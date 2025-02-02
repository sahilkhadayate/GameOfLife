package org.example;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class GridTest {

    @Test
    public void testGridCreationThrowsExceptionWhenRowIsNegative1(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 1));
    }
}
