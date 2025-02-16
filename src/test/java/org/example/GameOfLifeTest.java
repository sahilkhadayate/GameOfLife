package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameOfLifeTest {

    @Test
    public void testStartGame() {
        //Start the game
        GameOfLife gameOfLife = new GameOfLife(10, 10, 10);
        gameOfLife.startGame();

    }
}
