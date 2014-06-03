package com.arrggh.rpg.generator.description.generator;

public class Person {
    private String system;
    private String race;
    private String sex;
    private double height;
    private double weight;
    private String hair;
    private String eye;
    private String skin;
    private String heightDescription;
    private String weightDescription;
    
    public Person(String system,
                  String race,
                  String sex,
                  double height,
                  String heightDescription,
                  double weight,
                  String weightDescription,
                  String hair,
                  String eye,
                  String skin) {
        this.system = system;
        this.race = race;
        this.sex = sex;
        this.height = height;
        this.heightDescription = heightDescription;
        this.weight = weight;
        this.weightDescription = weightDescription;
        this.hair = hair;
        this.eye = eye;
        this.skin = skin;
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

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getHair() {
        return hair;
    }

    public String getEye() {
        return eye;
    }

    public String getSkin() {
        return skin;
    }

    public String getHeightDescription() {
        return heightDescription;
    }

    public String getWeightDescription() {
        return weightDescription;
    }
}
