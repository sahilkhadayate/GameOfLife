package org.example;

import java.util.Random;

public class Randomizer {
    private final Random random;

    public Randomizer() {
        this.random = new Random();
    }

    public Randomizer(long seed) {
        this.random = new Random(seed);
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}

