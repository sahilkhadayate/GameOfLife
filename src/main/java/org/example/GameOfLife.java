package org.example;

public class GameOfLife {

    private final Grid grid;

    public GameOfLife(int m, int n, int seedPercentage) {
        this.grid = new Grid(m, n);
        grid.initializeGrid(seedPercentage);
    }

    public void startGame() {
        grid.displayCurrentGridState();
        System.out.println("\n");
        addDelay();
        while (grid.canGridBeUpdatedFurther()) {
            grid.updateGrid();
            grid.displayCurrentGridState();

            System.out.println("\n");
            addDelay();
        }
    }

    private static void addDelay() {
        try {
            Thread.sleep(1000); // Pause for 500ms to simulate animation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
