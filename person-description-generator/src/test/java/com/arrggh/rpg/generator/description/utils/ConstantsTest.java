package com.arrggh.rpg.generator.description.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstantsTest {
    @Test
    public void testConstants() {
        assertEquals(0, Constants.EmptyArray.length);
        assertEquals(1, Constants.RandomArray.length);
        
        assertEquals("Random", Constants.Random);
        assertEquals("Random", Constants.RandomArray[0]);
    }
}
