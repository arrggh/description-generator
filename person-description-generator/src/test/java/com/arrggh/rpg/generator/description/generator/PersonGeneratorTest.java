package com.arrggh.rpg.generator.description.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.data.SystemRaceSexEntry;

public class PersonGeneratorTest {
    private GeneratorOptions options;
    private GeneratorOptions randomOptions;
    
    private DataStore store;

    private Set<String> hair;
    private Set<String> eye;
    private Set<String> skin;

    @Before
    public void setup() {
        options = new GeneratorOptions("system",
                                       "race",
                                       "sex",
                                       HeightOptions.Average,
                                       WeightOptions.Average,
                                       "hair",
                                       "eye",
                        "skin");
        
        randomOptions = new GeneratorOptions("system",
                                             "race",
                                             "sex",
                                             HeightOptions.Random,
                                             WeightOptions.Random,
                                             "Random",
                                             "Random",
                        "Random");

        hair = new HashSet<String>();
        hair.add("hair");
        eye = new HashSet<String>();
        eye.add("eye");
        skin = new HashSet<String>();
        skin.add("skin");

        store = new DataStore();
        Map<String, SystemRaceSexEntry> sexes = new HashMap<String, SystemRaceSexEntry>();
        Map<String, Map<String, SystemRaceSexEntry>> races = new HashMap<String, Map<String, SystemRaceSexEntry>>();
        sexes.put("sex", new SystemRaceSexEntry(180, 1, 200, 1, hair, eye, skin));
        races.put("race", sexes);
        store.add("system", races);
    }

    @Test
    public void testGenerator() {
        PersonGenerator generator = new PersonGenerator(store);
        Person person = generator.generatePerson(options);

        assertEquals("system", person.getSystem());
        assertEquals("race", person.getRace());
        assertEquals("sex", person.getSex());
        assertEquals(180.0, person.getHeight(), 1.0);
        assertEquals(200.0, person.getWeight(), 1.0);
        assertEquals("hair", person.getHair());
        assertEquals("eye", person.getEye());
        assertEquals("skin", person.getSkin());
        assertEquals("Average", person.getHeightDescription());
        assertEquals("Average", person.getWeightDescription());
    }
    
    @Test
    public void testGeneratorHandlesRandom() {
        PersonGenerator generator = new PersonGenerator(store);
        Person person = generator.generatePerson(randomOptions);

        assertEquals("system", person.getSystem());
        assertNotEquals("Random", person.getRace());
        assertNotEquals("Random", person.getSex());
        assertNotEquals("Random", person.getHair());
        assertNotEquals("Random", person.getEye());
        assertNotEquals("Random", person.getSkin());
        assertNotEquals("Random", person.getHeightDescription());
        assertNotEquals("Random", person.getWeightDescription());
    }
}
