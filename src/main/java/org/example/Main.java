package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();
        System.out.print("Enter percentage of alive cells: ");
        int seedingPercentage = scanner.nextInt();
        GameController gameController = new GameController(rows, columns, seedingPercentage);
        gameController.startGame();
    }
}
