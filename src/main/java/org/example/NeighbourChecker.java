package org.example;

@FunctionalInterface
public interface NeighbourChecker {
    boolean isNeighbourAlive(int x, int y);
}
