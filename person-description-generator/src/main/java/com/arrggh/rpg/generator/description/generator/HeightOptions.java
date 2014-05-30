package com.arrggh.rpg.generator.description.generator;

import java.util.Random;

public enum HeightOptions {
    Random("Random", -4, 4),
    ExtremelyShort("Extremely Short", -4, -3),
    VeryShort("Very Short", -3, -2),
    Short("Short", -2, -1),
    Average("Average", -1, 1),
    Tall("Tall", 1, 2),
    VeryTall("Very Tall", 2, 3),
    ExtremelyTall("Extremely Tall", 3, 4);

    private static final Random random = new Random();

    private final String text;
    private int minStdDev;
    private int maxStdDev;

    private HeightOptions(String text, int minStdDev, int maxStdDev) {
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
    
    public static String[] getHeights() {
        final HeightOptions[] values = values();
        final int lengths = values.length;
        final String[] results = new String[lengths];
        for (int i = 0; i != lengths; i++) {
            results[i] = values[i].getText();
        }
        return results;
    }

    public static HeightOptions getRandom() {
        return values()[random.nextInt(values().length - 1) + 1];
    }

    public static HeightOptions getHeight(String selectedHeight) {
        for (final HeightOptions height : values()) {
            if (height.getText().equals(selectedHeight)) {
                return height;
            }
        }
        throw new IllegalArgumentException("Height class [" + selectedHeight + "] is not recognized");
    }
}
