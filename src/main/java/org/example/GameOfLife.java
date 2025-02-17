package org.example;

public class GameOfLife {

    private final Grid grid;
    private String previousState;
    private String newState = "";
    public GameOfLife(int m, int n, int seedPercentage) {
        this.grid = new Grid(m, n, new Randomizer());
        grid.initializeGrid(seedPercentage);
    }

    public void startGame() {

       previousState = grid.displayCurrentGridState();
        System.out.println("\n");
        addDelay();
        while (!isGridStable()) {
            grid.updateGrid();
            newState = grid.displayCurrentGridState();
            System.out.println("\n");
            addDelay();
        }
    }

    private boolean isGridStable() {
       if (newState.equals(previousState)) {
            return true;
        }
        previousState = newState;
        return false;
    }
    private static void addDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
