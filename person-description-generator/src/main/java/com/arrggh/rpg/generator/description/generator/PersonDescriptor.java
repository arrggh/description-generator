package com.arrggh.rpg.generator.description.generator;

public class PersonDescriptor {
    public String generateString(Person person) {
        final StringBuilder builder = new StringBuilder();
        
        builder.append(String.format("System: %s\n", person.getSystem()));
        builder.append(String.format("Race: %s\n", person.getRace()));
        builder.append(String.format("Sex: %s\n", person.getSex()));
        builder.append(String.format("Height: %1.2fm / %s\n",
                                     person.getHeight() / 100,
                                     getImperialHeight(person.getHeight())));
        builder.append(String.format("Height Class: %s\n", person.getHeightDescription()));
        builder.append(String.format("Weight: %1.0fkg / %s\n",
                                     person.getWeight(),
                                     getImperialWeight(person.getWeight())));
        builder.append(String.format("Weight Class: %s\n", person.getWeightDescription()));
        builder.append(String.format("Skin Color: %s\n", person.getSkin()));
        builder.append(String.format("Eye Color: %s\n", person.getEye()));
        builder.append(String.format("Hair Color: %s\n", person.getHair()));
        
        return builder.toString();
    }
    
    private String getImperialWeight(double kilos) {
        final double totalPounds = 2.20462f * kilos;
        final double stones = Math.floor(totalPounds / 14.0);
        final double pounds = totalPounds - 14 * stones;
        return String.format("%1.0fst %1.0flbs / %1.0flbs", stones, pounds, totalPounds);
    }
    
    private String getImperialHeight(double cm) {
        final double totalInches = cm * 0.393700787f;
        final double feet = Math.floor(totalInches / 16.0f);
        final double inches = totalInches - 16 * feet;
        return String.format("%1.0fft %1.0fin", feet, inches);
    }
}
