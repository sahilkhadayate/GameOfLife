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
        while (grid.canUpdateGrid()) {
            grid.updateGrid();
            grid.printCurrentGridState();
            System.out.println("\n");
        }
    }
}
