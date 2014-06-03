package com.arrggh.rpg.generator.description.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayUtilsTest {
    private static final String[] EmptyStringArray = new String[] {};
    private static final String[] StringArrayOne = new String[] {"a", "b"};
    private static final String[] StringArrayTwo = new String[] {"c", "d"};
    private static final String[] StringArrayAll = new String[] {"a", "b", "c", "d"};

    @Test
    public void testArrayConcatTwoEmptyArrays() {
        String[] result = ArrayUtils.concat(EmptyStringArray, EmptyStringArray);
        assertEquals(0, result.length);
    }

    @Test
    public void testArrayConcatFirstArrayEmpty() {
        String[] result = ArrayUtils.concat(EmptyStringArray, StringArrayTwo);
        assertEquals(2, result.length);
        assertArrayEquals(StringArrayTwo, result);
    }

    @Test
    public void testArrayConcatSecondArrayEmpty() {
        String[] result = ArrayUtils.concat(StringArrayOne, EmptyStringArray);
        assertEquals(2, result.length);
        assertArrayEquals(StringArrayOne, result);
    }

    @Test
    public void testArrayConcatTwoArrays() {
        String[] result = ArrayUtils.concat(StringArrayOne, StringArrayTwo);
        assertEquals(4, result.length);
        assertArrayEquals(StringArrayAll, result);
    }
}
