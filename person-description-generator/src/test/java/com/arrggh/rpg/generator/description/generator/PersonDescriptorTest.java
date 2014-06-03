package com.arrggh.rpg.generator.description.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonDescriptorTest {
    
    @Test
    public void testDescriptionGeneration() {
        Person person = new Person("system", "race", "sex", 180.0, "height", 200.0, "weight", "hair", "eye", "skin");
        PersonDescriptor descriptor = new PersonDescriptor();
        String output = descriptor.generateString(person);
        String[] results = output.split("\n");
        assertEquals("System: system", results[0].trim());
        assertEquals("Race: race", results[1].trim());
        assertEquals("Sex: sex", results[2].trim());
        assertEquals("Height: 1.80m / 5ft 11in", results[3].trim());
        assertEquals("Height Class: height", results[4].trim());
        assertEquals("Weight: 200kg / 31st 7lbs / 441lbs", results[5].trim());
        assertEquals("Weight Class: weight", results[6].trim());
        assertEquals("Skin Color: skin", results[7].trim());
        assertEquals("Eye Color: eye", results[8].trim());
        assertEquals("Hair Color: hair", results[9].trim());
    }
}
