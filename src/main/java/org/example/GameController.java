package org.example;

public class GameController {

    private final Grid grid;

    public GameController(int m, int n, int seedPercentage) {
        this.grid = new Grid(m, n);
        grid.seedGrid(seedPercentage);
    }

    public void startGame() {
        grid.printCurrentGridState();
        System.out.println("\n");
        addDelay();
        while (grid.canGridBeUpdated()) {
            grid.updateGrid();
            grid.printCurrentGridState();
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
