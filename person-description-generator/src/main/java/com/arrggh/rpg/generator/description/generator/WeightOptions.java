package com.arrggh.rpg.generator.description.generator;

import java.util.Random;

public enum WeightOptions {
    Random("Random", -4, 4),
    ExtremelyLight("Extremely Light", -4, -3),
    VeryLight("Very Light", -3, -2),
    Light("Light", -2, -1),
    Average("Average", -1, 1),
    Heavy("Heavy", 1, 2),
    VeryHeavy("Very Heavy", 2, 3),
    ExtremelyHeavy("Extremely Heavy", 3, 4);

    private static final Random random = new Random();

    private final String text;
    private final int minStdDev;
    private final int maxStdDev;

    private WeightOptions(String text, int minStdDev, int maxStdDev) {
        this.text = text;
        this.minStdDev = minStdDev;
        this.maxStdDev = maxStdDev;
    }

    public String getText() {
        return text;
    }

    public int getMinStdDev() {
        return minStdDev;
    }

    public int getMaxStdDev() {
        return maxStdDev;
    }
    
    public static String[] getWeights() {
        final WeightOptions[] values = values();
        final int lengths = values.length;
        final String[] results = new String[lengths];
        for (int i = 0; i != lengths; i++) {
            results[i] = values[i].getText();
        }
        return results;
    }

    public static WeightOptions getRandom() {
        return values()[random.nextInt(values().length - 1) + 1];
    }

    public static WeightOptions getWeight(String selectedWeight) {
        for (final WeightOptions weight : values()) {
            if (weight.getText().equals(selectedWeight)) {
                return weight;
            }
        }
        throw new IllegalArgumentException("Weight class [" + selectedWeight + "] is not recognized");
    }
}
