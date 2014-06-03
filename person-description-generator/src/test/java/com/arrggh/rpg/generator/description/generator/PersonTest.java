package com.arrggh.rpg.generator.description.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
    
    @Test
    public void testPersonConstructorIsInRightOrder() {
        Person p = new Person("system", "race", "sex", 1.0, "height", 2.0, "weight", "hair", "eye", "skin");
        
        assertEquals("system", p.getSystem());
        assertEquals("race", p.getRace());
        assertEquals("sex", p.getSex());
        assertEquals(1.0, p.getHeight(), 0.001);
        assertEquals(2.0, p.getWeight(), 0.001);
        assertEquals("hair", p.getHair());
        assertEquals("eye", p.getEye());
        assertEquals("skin", p.getSkin());
        assertEquals("height", p.getHeightDescription());
        assertEquals("weight", p.getWeightDescription());
    }
}
