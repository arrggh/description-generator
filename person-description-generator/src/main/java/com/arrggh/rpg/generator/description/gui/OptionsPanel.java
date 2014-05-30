package com.arrggh.rpg.generator.description.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.generator.GeneratorOptions;
import com.arrggh.rpg.generator.description.generator.HeightOptions;
import com.arrggh.rpg.generator.description.generator.OptionsBuilder;
import com.arrggh.rpg.generator.description.generator.WeightOptions;
import com.arrggh.rpg.generator.description.utils.ArrayUtils;
import com.arrggh.rpg.generator.description.utils.Constants;

public class OptionsPanel extends JPanel {
    private static final long serialVersionUID = 3976432955858498234L;

    private final JComboBox<String> cmbSystem;
    private final JComboBox<String> cmbRace;
    private final JComboBox<String> cmbSex;

    private final JComboBox<String> cmbHeight;
    private final JComboBox<String> cmbWeight;

    private final JComboBox<String> cmbEyeColor;
    private final JComboBox<String> cmbHairColor;
    private final JComboBox<String> cmbSkinColor;

    private final DataStore store;

    public OptionsPanel(DataStore dataStore) {
        store = dataStore;
        setLayout(new MigLayout());

        cmbSystem = new JComboBox<String>(getPossibleSystems());
        cmbRace = new JComboBox<String>(getPossibleRaces());
        cmbSex = new JComboBox<String>(getPossibleSexes());

        cmbHeight = new JComboBox<String>(HeightOptions.getHeights());
        cmbWeight = new JComboBox<String>(WeightOptions.getWeights());

        cmbEyeColor = new JComboBox<String>(getPossibleEyeColors());
        cmbHairColor = new JComboBox<String>(getPossibleHairColors());
        cmbSkinColor = new JComboBox<String>(getPossibleSkinColors());

        cmbSystem.addActionListener(generateActionListener(true, true));
        cmbRace.addActionListener(generateActionListener(false, true));
        cmbSex.addActionListener(generateActionListener(false, false));

        add(new JLabel("System"), "cell 0 0, sg LABEL");
        add(cmbSystem, "cell 1 0, sg COMBO");
        add(new JLabel("Race"), "cell 2 0, sg LABEL");
        add(cmbRace, "cell 3 0, sg COMBO");
        add(new JLabel("Sex"), "cell 4 0, sg LABEL");
        add(cmbSex, "cell 5 0, sg COMBO");

        add(new JLabel("Height"), "cell 0 1, sg LABEL");
        add(cmbHeight, "cell 1 1, sg COMBO");
        add(new JLabel("Weight"), "cell 2 1, sg LABEL");
        add(cmbWeight, "cell 3 1, sg COMBO");

        add(new JLabel("Eye Color"), "cell 0 2, sg LABEL");
        add(cmbEyeColor, "cell 1 2, sg COMBO");
        add(new JLabel("Hair Color"), "cell 2 2, sg LABEL");
        add(cmbHairColor, "cell 3 2, sg COMBO");
        add(new JLabel("Skin Color"), "cell 4 2, sg LABEL");
        add(cmbSkinColor, "cell 5 2, sg COMBO");
    }

    private ActionListener generateActionListener(final boolean race, final boolean sex) {
        return event -> {
            if (event.getID() == ActionEvent.ACTION_LAST) {
                if (race) {
                    cmbRace.setModel(new DefaultComboBoxModel<String>(getPossibleRaces()));
                }
                if (sex) {
                    cmbSex.setModel(new DefaultComboBoxModel<String>(getPossibleSexes()));
                }

                cmbEyeColor.setModel(new DefaultComboBoxModel<String>(getPossibleEyeColors()));
                cmbHairColor.setModel(new DefaultComboBoxModel<String>(getPossibleHairColors()));
                cmbSkinColor.setModel(new DefaultComboBoxModel<String>(getPossibleSkinColors()));
            }
        };
    }

    public GeneratorOptions getSelectedOptions() {
        OptionsBuilder builder = new OptionsBuilder();

        builder.system(getSystem());
        builder.race(getRace());
        builder.sex(getSex());

        builder.height(HeightOptions.getHeight(cmbHeight.getSelectedItem().toString()));
        builder.weight(WeightOptions.getWeight(cmbWeight.getSelectedItem().toString()));

        builder.hairColor(cmbHairColor.getSelectedItem().toString());
        builder.eyeColor(cmbEyeColor.getSelectedItem().toString());
        builder.skinColor(cmbSkinColor.getSelectedItem().toString());

        return builder.build();
    }

    /*
     * Helper methods to get the currently selected items
     */

    private String getSex() {
        return cmbSex.getSelectedItem().toString();
    }

    private String getRace() {
        return cmbRace.getSelectedItem().toString();
    }

    private String getSystem() {
        return cmbSystem.getSelectedItem().toString();
    }

    private String[] getPossibleSystems() {
        return appendRandomToSet(store.getSystems());
    }

    /*
     * Helper methods to get the list of items for the combo boxes
     */
    
    private String[] getPossibleRaces() {
        if (getSystem().equals(Constants.Random)) {
            return Constants.RandomArray;
        }
        return appendRandomToSet(store.getRaces(getSystem()));
    }

    private String[] getPossibleSexes() {
        if (getRace().equals(Constants.Random)) {
            return Constants.RandomArray;
        }
        return appendRandomToSet(store.getSexes(getSystem(), getRace()));
    }

    private String[] getPossibleHairColors() {
        if (getSex().equals(Constants.Random)) {
            return Constants.RandomArray;
        }
        return appendRandomToSet(store.getHairColors(getSystem(), getRace(), getSex()));
    }

    private String[] getPossibleEyeColors() {
        if (getSex().equals(Constants.Random)) {
            return Constants.RandomArray;
        }
        return appendRandomToSet(store.getEyeColors(getSystem(), getRace(), getSex()));
    }

    private String[] getPossibleSkinColors() {
        if (getSex().equals(Constants.Random)) {
            return Constants.RandomArray;
        }
        return appendRandomToSet(store.getSkinColors(getSystem(), getRace(), getSex()));
    }

    private String[] appendRandomToSet(Set<String> options) {
        return ArrayUtils.concat(Constants.RandomArray, options.toArray(Constants.EmptyArray));
    }
}
