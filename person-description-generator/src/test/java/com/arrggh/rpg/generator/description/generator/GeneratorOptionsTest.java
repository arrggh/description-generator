package com.arrggh.rpg.generator.description.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GeneratorOptionsTest {
    
    @Test
    public void testGeneratorOptionsConstructorIsInRightOrder() {
        GeneratorOptions options = new GeneratorOptions("system",
                                                        "race",
                                                        "sex",
                                                        HeightOptions.Average,
                                                        WeightOptions.Average,
                                                        "hair",
                                                        "eye",
                                                        "skin");

        assertEquals("system", options.getSystem());
        assertEquals("race", options.getRace());
        assertEquals("sex", options.getSex());
        assertEquals("hair", options.getHairColor());
        assertEquals("eye", options.getEyeColor());
        assertEquals("skin", options.getSkinColor());
        assertEquals(HeightOptions.Average, options.getHeight());
        assertEquals(WeightOptions.Average, options.getWeight());
    }
}
