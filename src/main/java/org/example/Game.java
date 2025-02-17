package org.example;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter seeding percentage (0-100): ");
        int seedingPercentage = scanner.nextInt();

        if (m <= 0 || n <= 0 || seedingPercentage < 0 || seedingPercentage > 100) {
            System.out.println("Invalid input! Please enter positive values and a valid percentage.");
            return;
        }


        // Start the game
        GameOfLife game = new GameOfLife(m, n, seedingPercentage);
        game.startGame();

        scanner.close();
    }
}
