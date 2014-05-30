package com.arrggh.rpg.generator.description;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.arrggh.rpg.generator.description.gui.GeneratorWindow;

public class Generator {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            GeneratorWindow window = new GeneratorWindow();
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            window.setVisible(true);
        });
    }
}
