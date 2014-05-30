package com.arrggh.rpg.generator.description.datasets;

import static com.arrggh.rpg.generator.description.datasets.GenericData.GenericEyeColors;
import static com.arrggh.rpg.generator.description.datasets.GenericData.GenericHairColors;
import static com.arrggh.rpg.generator.description.datasets.GenericData.GenericSkinColors;

import java.util.HashMap;
import java.util.Map;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.data.SystemRaceSexEntry;

/**
 * The parameters for the Dungeons & Dragons 3/3.5 character classes
 *
 * The numbers in this file were derived from the numbers in the Dungeons &
 * Dragons v3 game books.
 *
 * © 1995-2014 Wizards of the Coast LLC, a subsidiary of Hasbro, Inc. Dungeon &
 * Dragons is a registered trademark of Wizards of the Coast. All Rights
 * Reserved.
 *
 */
public class DungeonsAndDragons3 {
    public static void initialise(DataStore store) {
        Map<String, Map<String, SystemRaceSexEntry>> races = new HashMap<>();

        Map<String, SystemRaceSexEntry> humans = new HashMap<>();
        humans.put("Male", new SystemRaceSexEntry(175.3, 7.6, 79.5, 15.9, GenericHairColors, GenericEyeColors, GenericSkinColors));
        humans.put("Female", new SystemRaceSexEntry(162.6, 7.6, 63.6, 15.9, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Humans", humans);

        Map<String, SystemRaceSexEntry> dwarfs = new HashMap<>();
        dwarfs.put("Male", new SystemRaceSexEntry(127.0, 2.5, 75.0, 9.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        dwarfs.put("Female", new SystemRaceSexEntry(121.9, 2.5, 61.4, 9.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Dwarf", dwarfs);

        Map<String, SystemRaceSexEntry> elfs = new HashMap<>();
        elfs.put("Male", new SystemRaceSexEntry(152.4, 4.2, 49.8, 7.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        elfs.put("Female", new SystemRaceSexEntry(152.4, 4.2, 47.5, 7.2, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Elf", elfs);

        Map<String, SystemRaceSexEntry> gnomes = new HashMap<>();
        gnomes.put("Male", new SystemRaceSexEntry(104.1, 2.5, 20.5, 0.5, GenericHairColors, GenericEyeColors, GenericSkinColors));
        dwarfs.put("Female", new SystemRaceSexEntry(99.1, 2.5, 18.2, 0.5, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Gnome", gnomes);

        Map<String, SystemRaceSexEntry> halfElfs = new HashMap<>();
        halfElfs.put("Male", new SystemRaceSexEntry(162.6, 5.9, 65.9, 12.6, GenericHairColors, GenericEyeColors, GenericSkinColors));
        halfElfs.put("Female", new SystemRaceSexEntry(157.5, 5.9, 56.8, 12.6, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Half-Elf", halfElfs);

        Map<String, SystemRaceSexEntry> halfOrcs = new HashMap<>();
        halfOrcs.put("Male", new SystemRaceSexEntry(180.3, 9.3, 109.5, 29.8, GenericHairColors, GenericEyeColors, GenericSkinColors));
        halfOrcs.put("Female", new SystemRaceSexEntry(167.6, 9.3, 91.4, 29.8, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Half-Orc", halfOrcs);

        Map<String, SystemRaceSexEntry> halflings = new HashMap<>();
        halflings.put("Male", new SystemRaceSexEntry(94.0, 2.5, 15.9, 0.5, GenericHairColors, GenericEyeColors, GenericSkinColors));
        halflings.put("Female", new SystemRaceSexEntry(88.9, 2.5, 13.6, 0.5, GenericHairColors, GenericEyeColors, GenericSkinColors));
        races.put("Halfling", halflings);

        store.add("Dungeons & Dragons (3.X)", races);
    }
}
