package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameOfLifeTest {

    @Test
    public void testStartGameWith10X10GridAnd20percentSeeding() {
        //Start the game
        GameOfLife gameOfLife = new GameOfLife(10, 10, 20);
        gameOfLife.startGame();

    }
}
