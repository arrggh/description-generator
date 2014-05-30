package com.arrggh.rpg.generator.description.generator;


public class GeneratorOptions {
    private final String system;
    private final String race;
    private final String sex;
    private final HeightOptions height;
    private final WeightOptions weight;
    private final String hairColor;
    private final String eyeColor;
    private final String skinColor;
    
    public GeneratorOptions(String system,
                            String race,
                            String sex,
                            HeightOptions height,
                            WeightOptions weight,
                            String hairColor,
                            String eyeColor,
                            String skinColor) {
        this.system = system;
        this.race = race;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
    }

    public String getSystem() {
        return system;
    }

    public String getRace() {
        return race;
    }

    public String getSex() {
        return sex;
    }
    
    public String getHairColor() {
        return hairColor;
    }
    
    public String getEyeColor() {
        return eyeColor;
    }
    
    public String getSkinColor() {
        return skinColor;
    }

    public HeightOptions getHeight() {
        return height;
    }

    public WeightOptions getWeight() {
        return weight;
    }
}
