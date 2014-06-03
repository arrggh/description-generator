package com.arrggh.rpg.generator.description.generator;

import java.util.Random;
import java.util.Set;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.data.SystemRaceSexEntry;
import com.arrggh.rpg.generator.description.utils.Constants;

public class PersonGenerator {
    private static final Random random = new Random();
    
    private final DataStore store;
    
    public PersonGenerator(DataStore store) {
        this.store = store;
    }
    
    public Person generatePerson(GeneratorOptions options) {
        String system = options.getSystem();
        String race = options.getRace();
        String sex = options.getSex();
        
        system = randomiseIfNeeded(system, store.getSystems());
        race = randomiseIfNeeded(race, store.getRaces(system));
        sex = randomiseIfNeeded(sex, store.getSexes(system, race));
        
        SystemRaceSexEntry entry = store.getEntry(system, race, sex);
        
        String hairColor = options.getHairColor();
        String eyeColor = options.getEyeColor();
        String skinColor = options.getSkinColor();
        
        hairColor = randomiseIfNeeded(hairColor, entry.getHairColors());
        eyeColor = randomiseIfNeeded(eyeColor, entry.getEyeColors());
        skinColor = randomiseIfNeeded(skinColor, entry.getSkinColors());
        
        HeightOptions heightOptions = options.getHeight();
        WeightOptions weightOptions = options.getWeight();
        
        heightOptions = randomiseIfNeeded(heightOptions, HeightOptions.getNonRandomValues());
        weightOptions = randomiseIfNeeded(weightOptions, WeightOptions.getNonRandomValues());
        
        int hMin = heightOptions.getMinStdDev();
        int hMax = heightOptions.getMaxStdDev();
        
        int wMin = weightOptions.getMinStdDev();
        int wMax = weightOptions.getMaxStdDev();
        
        double height = entry.getHeightAverage() + generateStdDev(hMin, hMax) * entry.getHeightStdDev();
        double weight = entry.getWeightAverage() + generateStdDev(wMin, wMax) * entry.getWeightStdDev();
        
        weight = heightOptions.getWeightModifier() * weight;

        return new Person(system,
                          race,
                          sex,
                          height,
                          heightOptions.getText(),
                          weight,
                          weightOptions.getText(),
                          hairColor,
                          eyeColor,
                          skinColor);
    }
    
    private static String randomiseIfNeeded(String value, Set<String> values) {
        if (value.equals(Constants.Random)) {
            return values.toArray(new String[0])[random.nextInt(values.size())];
        }
        return value;
    }
    
    private static HeightOptions randomiseIfNeeded(HeightOptions value, Set<HeightOptions> values) {
        if (value.equals(HeightOptions.Random)) {
            return values.toArray(new HeightOptions[0])[random.nextInt(values.size())];
        }
        return value;
    }
    
    private static WeightOptions randomiseIfNeeded(WeightOptions value, Set<WeightOptions> values) {
        if (value.equals(WeightOptions.Random)) {
            return values.toArray(new WeightOptions[0])[random.nextInt(values.size())];
        }
        return value;
    }
    
    private double generateStdDev(int min, int max) {
        return min + (max - min) * random.nextFloat();
    }
}
