package org.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameControllerTest {

    @Test
    public void testStartGame() {
        //Start the game
        GameController gameController = new GameController(5,5,50);
        gameController.startGame();

    }
}
