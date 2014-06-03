package com.arrggh.rpg.generator.description.generator;

public class PersonDescriptor {
    private static final float InchesPerFoot = 12.0f;
    private static final float InchesPerCentimeter = 0.393700787f;
    private static final float KiloPerPound = 2.20462f;
    private static final double PoundsPerStone = 14.0;
    
    public String generateString(Person person) {
        final StringBuilder builder = new StringBuilder();

        builder.append(String.format("System: %s%n", person.getSystem()));
        builder.append(String.format("Race: %s%n", person.getRace()));
        builder.append(String.format("Sex: %s%n", person.getSex()));
        builder.append(String.format("Height: %1.2fm / %s%n", person.getHeight() / 100, getImperialHeight(person.getHeight())));
        builder.append(String.format("Height Class: %s%n", person.getHeightDescription()));
        builder.append(String.format("Weight: %1.0fkg / %s%n", person.getWeight(), getImperialWeight(person.getWeight())));
        builder.append(String.format("Weight Class: %s%n", person.getWeightDescription()));
        builder.append(String.format("Skin Color: %s%n", person.getSkin()));
        builder.append(String.format("Eye Color: %s%n", person.getEye()));
        builder.append(String.format("Hair Color: %s%n", person.getHair()));

        return builder.toString();
    }

    private String getImperialWeight(double kilos) {
        final double totalPounds = KiloPerPound * kilos;
        final double stones = Math.floor(totalPounds / PoundsPerStone);
        final double pounds = totalPounds - PoundsPerStone * stones;
        return String.format("%1.0fst %1.0flbs / %1.0flbs", stones, pounds, totalPounds);
    }

    private String getImperialHeight(double cm) {
        final double totalInches = cm * InchesPerCentimeter;
        final double feet = Math.floor(totalInches / InchesPerFoot);
        final double inches = totalInches - InchesPerFoot * feet;
        return String.format("%1.0fft %1.0fin", feet, inches);
    }
}
