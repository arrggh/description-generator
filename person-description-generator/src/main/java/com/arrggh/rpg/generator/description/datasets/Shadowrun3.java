package com.arrggh.rpg.generator.description.datasets;

import static com.arrggh.rpg.generator.description.datasets.GenericData.GenericEyeColors;
import static com.arrggh.rpg.generator.description.datasets.GenericData.GenericHairColors;
import static com.arrggh.rpg.generator.description.datasets.GenericData.GenericSkinColors;

import java.util.HashMap;
import java.util.Map;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.data.SystemRaceSexEntry;

/**
 * The parameters for the Shadowrun 3 character classes.
 *
 * The numbers in this file were derived from the numbers in the Shadowrun game
 * books.
 *
 * © 2001-2014 The Topps Company, Inc. Shadowrun is a registered trademark of
 * The Topps Company, Inc. All Rights Reserved.
 */
public class Shadowrun3 {
    public static void initialise(DataStore store) {
        Map<String, Map<String, SystemRaceSexEntry>> races = new HashMap<>();
        
        Map<String, SystemRaceSexEntry> humans = new HashMap<>();
        humans.put("Male", new SystemRaceSexEntry(170.0, 19.8, 70.0, 8.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        humans.put("Female", new SystemRaceSexEntry(156.0, 18.2, 54.5, 6.4, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Human", humans);
        
        Map<String, SystemRaceSexEntry> orcs = new HashMap<>();
        orcs.put("Male", new SystemRaceSexEntry(190.0, 22.1, 125.1, 14.6, GenericHairColors, GenericEyeColors, GenericSkinColors));
        orcs.put("Female", new SystemRaceSexEntry(182.0, 21.2, 110.0, 12.8, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Orc", orcs);
        
        Map<String, SystemRaceSexEntry> trolls = new HashMap<>();
        trolls.put("Male", new SystemRaceSexEntry(280.0, 32.6, 491.1, 57.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        trolls.put("Female", new SystemRaceSexEntry(257.6, 30.1, 383.1, 44.7, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Troll", trolls);
        
        Map<String, SystemRaceSexEntry> elfs = new HashMap<>();
        elfs.put("Male", new SystemRaceSexEntry(190.0, 22.1, 78.2, 9.1, GenericHairColors, GenericEyeColors, GenericSkinColors));
        elfs.put("Female", new SystemRaceSexEntry(175.0, 20.4, 60.9, 7.1, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Elf", elfs);
        
        Map<String, SystemRaceSexEntry> dwarfs = new HashMap<>();
        dwarfs.put("Male", new SystemRaceSexEntry(120.0, 14.0, 44.3, 5.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        dwarfs.put("Female", new SystemRaceSexEntry(110.0, 12.8, 45.0, 5.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Dwarf", dwarfs);
        
        store.add("Shadowrun 3", races);
    }
}
