package com.arrggh.rpg.generator.description.generator;

import java.util.HashSet;
import java.util.Set;

public enum WeightOptions {
    Random("Random", -4, 4),
    ExtremelyLight("Extremely Light", -4, -3),
    VeryLight("Very Light", -3, -2),
    Light("Light", -2, -1),
    Average("Average", -1, 1),
    Heavy("Heavy", 1, 2),
    VeryHeavy("Very Heavy", 2, 3),
    ExtremelyHeavy("Extremely Heavy", 3, 4);

    private static Set<WeightOptions> NonRandomOptions = new HashSet<>();
    static {
        NonRandomOptions.add(ExtremelyLight);
        NonRandomOptions.add(VeryLight);
        NonRandomOptions.add(Light);
        NonRandomOptions.add(Average);
        NonRandomOptions.add(Heavy);
        NonRandomOptions.add(VeryHeavy);
        NonRandomOptions.add(ExtremelyHeavy);
    }

    private static String[] WeightTexts = new String[] {Random.getText(),
                                                        ExtremelyLight.getText(),
                                                        VeryLight.getText(),
                                                        Light.getText(),
                                                        Average.getText(),
                                                        Heavy.getText(),
                                                        VeryHeavy.getText(),
                                                        ExtremelyHeavy.getText()};

    private String text;
    private int minStdDev;
    private int maxStdDev;

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
        return WeightTexts;
    }

    public static Set<WeightOptions> getNonRandomValues() {
        return NonRandomOptions;
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
