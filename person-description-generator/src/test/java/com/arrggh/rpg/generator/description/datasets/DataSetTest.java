package com.arrggh.rpg.generator.description.datasets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.data.SystemRaceSexEntry;

public class DataSetTest {
    private void checkDataConsistency(DataStore store, int raceCount, int sexCount) {
        Set<String> systems = store.getSystems();
        assertEquals(1, systems.size());
        for (String system : systems) {
            Set<String> races = store.getRaces(system);
            assertEquals(raceCount, races.size());
            for (String race : races) {
                Set<String> sexes = store.getSexes(system, race);
                assertEquals(sexCount, sexes.size());
                for (String sex : sexes) {
                    SystemRaceSexEntry entry = store.getEntry(system, race, sex);
                    assertNotNull(entry);

                    assertNotEquals(0, entry.getHeightAverage(), 0.0);
                    assertNotEquals(0, entry.getHeightStdDev(), 0.0);
                    assertNotEquals(0, entry.getWeightAverage(), 0.0);
                    assertNotEquals(0, entry.getWeightStdDev(), 0.0);

                    Set<String> hairColors = entry.getHairColors();
                    Set<String> eyeColors = entry.getEyeColors();
                    Set<String> skinColors = entry.getSkinColors();
                    assertNotNull(hairColors);
                    assertNotNull(eyeColors);
                    assertNotNull(skinColors);
                    assertNotEquals(0, hairColors.size());
                    assertNotEquals(0, eyeColors.size());
                    assertNotEquals(0, skinColors.size());
                }
            }
        }
    }

    @Test
    public void testShadowrunDataSetConsistency() {
        DataStore store = new DataStore();
        Shadowrun3.initialise(store);
        checkDataConsistency(store, 5, 2);
    }

    @Test
    public void testDungeonsAndDragonsDataSetConsistency() {
        DataStore store = new DataStore();
        DungeonsAndDragons3.initialise(store);
        checkDataConsistency(store, 7, 2);
    }
}
