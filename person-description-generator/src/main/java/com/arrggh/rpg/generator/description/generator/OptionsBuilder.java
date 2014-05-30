package com.arrggh.rpg.generator.description.generator;


public class OptionsBuilder {
    private String system;
    private String race;
    private String sex;
    private String skinColor;
    private String eyeColor;
    private String hairColor;
    private HeightOptions height;
    private WeightOptions weight;

    public OptionsBuilder() {
    }

    public OptionsBuilder system(String system) {
        this.system = system;
        return this;
    }

    public OptionsBuilder race(String race) {
        this.race = race;
        return this;
    }

    public OptionsBuilder sex(String sex) {
        this.sex = sex;
        return this;
    }

    public OptionsBuilder hairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public OptionsBuilder eyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    public OptionsBuilder skinColor(String skinColor) {
        this.skinColor = skinColor;
        return this;
    }

    public OptionsBuilder height(HeightOptions height) {
        if (height == HeightOptions.Random) {
            this.height = HeightOptions.getRandom();
        }
        else {
            this.height = height;
        }
        return this;
    }

    public OptionsBuilder weight(WeightOptions weight) {
        if (weight == WeightOptions.Random) {
            this.weight = WeightOptions.getRandom();
        }
        else {
            this.weight = weight;
        }
        return this;
    }

    public GeneratorOptions build() {
        checkIsNull("System", system);
        checkIsNull("Race", race);
        checkIsNull("Sex", sex);
        checkIsNull("Height", height);
        checkIsNull("Weight", weight);
        checkIsNull("Hair Color", hairColor);
        checkIsNull("Eye Color", eyeColor);
        checkIsNull("Skin Color", skinColor);
        return new GeneratorOptions(system, race, sex, height, weight, hairColor, eyeColor, skinColor);
    }

    private static void checkIsNull(String description, Object object) {
        if (object == null) {
            throw new IllegalStateException("The option " + description + " cannot be null");
        }
    }
}
