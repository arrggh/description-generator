package com.arrggh.rpg.generator.description.datasets;

import java.util.HashSet;
import java.util.Set;

public class GenericData {
    public static final Set<String> GenericHairColors = new HashSet<>();
    public static final Set<String> GenericEyeColors = new HashSet<>();
    public static final Set<String> GenericSkinColors = new HashSet<>();
    
    static {
        GenericEyeColors.add("Blue");
        GenericEyeColors.add("Brown");
        GenericEyeColors.add("Grey");
        GenericEyeColors.add("Green");
        
        GenericHairColors.add("Brown");
        GenericHairColors.add("Black");
        GenericHairColors.add("Grey");
        GenericHairColors.add("Blonde");
        GenericHairColors.add("Red");
        
        GenericSkinColors.add("Pale White");
        GenericSkinColors.add("White");
        GenericSkinColors.add("Cream White");
        GenericSkinColors.add("Moderate Brown");
        GenericSkinColors.add("Dark Brown");
        GenericSkinColors.add("Black");
    }
}
