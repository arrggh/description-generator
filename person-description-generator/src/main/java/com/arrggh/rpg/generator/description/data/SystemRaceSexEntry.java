package com.arrggh.rpg.generator.description.data;

import java.util.Set;

public class SystemRaceSexEntry {
    private double heightAverage;
    private double heightStdDev;
    private double weightAverage;
    private double weightStdDev;
    private Set<String> hairColors;
    private Set<String> eyeColors;
    private Set<String> skinColors;
    
    /**
     * Create an instance of the Entry
     *
     * @param heightAverage The average height (in centimeters)
     * @param heightStdDev The standard deviation of the height (in centimeters)
     * @param weightAverage The average weight (in kilograms)
     * @param weightStdDev The standard deviation of the weight (in kilograms)
     * @param hairColors The set of possible Hair Colors
     * @param eyeColors The set of possible Eye Colors
     * @param skinColors The set of possible Skin Colors
     */
    public SystemRaceSexEntry(double heightAverage,
                              double heightStdDev,
                              double weightAverage,
                              double weightStdDev,
                              Set<String> hairColors,
                              Set<String> eyeColors,
                              Set<String> skinColors) {
        this.heightAverage = heightAverage;
        this.heightStdDev = heightStdDev;
        this.weightAverage = weightAverage;
        this.weightStdDev = weightStdDev;
        this.hairColors = hairColors;
        this.eyeColors = eyeColors;
        this.skinColors = skinColors;
    }
    
    public double getHeightAverage() {
        return heightAverage;
    }
    
    public double getHeightStdDev() {
        return heightStdDev;
    }
    
    public double getWeightAverage() {
        return weightAverage;
    }
    
    public double getWeightStdDev() {
        return weightStdDev;
    }
    
    public Set<String> getHairColors() {
        return hairColors;
    }
    
    public Set<String> getEyeColors() {
        return eyeColors;
    }
    
    public Set<String> getSkinColors() {
        return skinColors;
    }
}
