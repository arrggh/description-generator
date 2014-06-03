package com.arrggh.rpg.generator.description.gui;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.arrggh.rpg.generator.description.Generator;

public class AboutDialog extends JDialog {
    private static final long serialVersionUID = 7665492010962142864L;
    
    public AboutDialog(JFrame parent) {
        super(parent, "Help: About", true);
        setLayout(new BorderLayout());
        
        JButton close = new JButton("Close");
        close.addActionListener(arg -> this.dispose());

        JTabbedPane pane = new JTabbedPane();
        pane.add(getText("description.txt"), "Description");
        pane.add(getText("licence.txt"), "Licence");
        pane.add(getText("trademarks.txt"), "Trademarks");
        pane.add(getText("dependencies.txt"), "Dependencies");

        add(pane, BorderLayout.CENTER);
        add(close, BorderLayout.SOUTH);
        
        pack();
    }
    
    private JComponent getText(String filename) {
        String result = readText(filename);
        JTextArea area = new JTextArea(result.toString());
        area.setEditable(false);
        return area;
    }

    private String readText(String filename) {
        StringBuilder result = new StringBuilder();
        InputStream resource = Generator.class.getResourceAsStream(filename);
        if (resource == null) {
            return "Unable to find: " + filename;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            String line = reader.readLine();
            while (line != null) {
                result.append(line);
                result.append("\n");
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            return "Unable to read: " + filename + "\n" + e.getMessage();
        }
        return result.toString();
    }
    
    public static void display(JFrame parent) {
        AboutDialog dialog = new AboutDialog(parent);
        dialog.setVisible(true);
    }
}
