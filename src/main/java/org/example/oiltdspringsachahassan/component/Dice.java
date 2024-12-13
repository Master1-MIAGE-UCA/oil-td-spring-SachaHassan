package org.example.oiltdspringsachahassan.component;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Dice {

    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    /**
     * Simule un lancé de dé à 6 faces.
     * @return un entier entre 1 et 6.
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }

    /**
     * Simule plusieurs lancés de dés.
     * @param numberOfDice nombre de dés à lancer.
     * @return un tableau contenant les résultats de chaque lancé.
     */
    public int[] rollMultiple(int numberOfDice) {
        int[] results = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            results[i] = roll();
        }
        return results;
    }
}

