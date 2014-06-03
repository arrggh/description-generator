package com.arrggh.rpg.generator.description.generator;

import java.util.HashSet;
import java.util.Set;

public enum HeightOptions {
    Random("Random", -4, 4, 1.0),
    ExtremelyShort("Extremely Short", -4, -3, 0.85),
    VeryShort("Very Short", -3, -2, 0.90),
    Short("Short", -2, -1, 0.95),
    Average("Average", -1, 1, 1.0),
    Tall("Tall", 1, 2, 1.05),
    VeryTall("Very Tall", 2, 3, 1.10),
    ExtremelyTall("Extremely Tall", 3, 4, 1.15);
    
    private static Set<HeightOptions> NonRandomOptions = new HashSet<>();
    static {
        NonRandomOptions.add(ExtremelyShort);
        NonRandomOptions.add(VeryShort);
        NonRandomOptions.add(Short);
        NonRandomOptions.add(Average);
        NonRandomOptions.add(Tall);
        NonRandomOptions.add(VeryTall);
        NonRandomOptions.add(ExtremelyTall);
    }
    
    private static String[] HeightTexts = new String[] {Random.getText(),
                                                        ExtremelyShort.getText(),
                                                        VeryShort.getText(),
                                                        Short.getText(),
                                                        Average.getText(),
                                                        Tall.getText(),
                                                        VeryTall.getText(),
                                                        ExtremelyTall.getText()};
    private String text;
    private int minStdDev;
    private int maxStdDev;
    
    private double weightModifier;
    
    private HeightOptions(String text, int minStdDev, int maxStdDev, double weightModifier) {
        this.text = text;
        this.minStdDev = minStdDev;
        this.maxStdDev = maxStdDev;
        this.weightModifier = weightModifier;
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
    
    public double getWeightModifier() {
        return weightModifier;
    }
    
    public static String[] getHeights() {
        return HeightTexts;
    }
    
    public static Set<HeightOptions> getNonRandomValues() {
        return NonRandomOptions;
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
