package com.arrggh.rpg.generator.description.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class OptionsBuilderTest {

    @Test
    public void testOptionsGoodCase() {
        OptionsBuilder builder = new OptionsBuilder();

        builder.system("system");
        builder.race("race");
        builder.sex("sex");
        builder.hairColor("hair");
        builder.eyeColor("eye");
        builder.skinColor("skin");
        builder.height(HeightOptions.ExtremelyShort);
        builder.weight(WeightOptions.VeryHeavy);

        GeneratorOptions options = builder.build();

        assertEquals("system", options.getSystem());
        assertEquals("race", options.getRace());
        assertEquals("sex", options.getSex());
        assertEquals("hair", options.getHairColor());
        assertEquals("eye", options.getEyeColor());
        assertEquals("skin", options.getSkinColor());
        assertEquals(HeightOptions.ExtremelyShort, options.getHeight());
        assertEquals(WeightOptions.VeryHeavy, options.getWeight());
    }

    @Test
    public void testOptionsCaseWithNullThrowsException() {
        for (int i = 0; i != 0xFF; i++) {
            boolean system = (i & 0x80) == 0x80;
            boolean race = (i & 0x40) == 0x40;
            boolean sex = (i & 0x20) == 0x20;
            boolean hair = (i & 0x10) == 0x10;
            boolean eye = (i & 0x08) == 0x08;
            boolean skin = (i & 0x04) == 0x04;
            boolean height = (i & 0x02) == 0x02;
            boolean weight = (i & 0x01) == 0x01;
            checkNullIsThrown(i, system, race, sex, hair, eye, skin, height, weight);
        }
    }

    private void checkNullIsThrown(int i,
                                   boolean system,
                                   boolean race,
                                   boolean sex,
                                   boolean hair,
                                   boolean eye,
                                   boolean skin,
                                   boolean height,
                                   boolean weight) {

        OptionsBuilder builder = new OptionsBuilder();

        if (system) {
            builder.system("system");
        }
        if (race) {
            builder.race("race");
        }
        if (sex) {
            builder.sex("sex");
        }
        if (hair) {
            builder.hairColor("hair");
        }
        if (eye) {
            builder.eyeColor("eye");
        }
        if (skin) {
            builder.skinColor("skin");
        }
        if (height) {
            builder.height(HeightOptions.ExtremelyShort);
        }
        if (weight) {
            builder.weight(WeightOptions.VeryHeavy);
        }

        try {
            builder.build();
            fail("Should have thrown an exception: " + i);
        }
        catch (IllegalStateException e) {
        }
    }
}
