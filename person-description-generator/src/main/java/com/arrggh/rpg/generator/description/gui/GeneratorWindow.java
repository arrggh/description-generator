package com.arrggh.rpg.generator.description.gui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.arrggh.rpg.generator.description.data.DataStore;
import com.arrggh.rpg.generator.description.datasets.DungeonsAndDragons3;
import com.arrggh.rpg.generator.description.datasets.Shadowrun3;
import com.arrggh.rpg.generator.description.generator.GeneratorOptions;
import com.arrggh.rpg.generator.description.generator.Person;
import com.arrggh.rpg.generator.description.generator.PersonDescriptor;
import com.arrggh.rpg.generator.description.generator.PersonGenerator;

public class GeneratorWindow extends JFrame {
    private static final long serialVersionUID = -2459512734542496802L;
    
    private final JTextArea txtArea;
    private final OptionsPanel pnlOptions;
    private final JButton btnGenerate;
    
    private final PersonGenerator generator;
    private final PersonDescriptor descriptor;
    
    public GeneratorWindow() {
        super("Person Generator");
        
        addMenu();

        DataStore store = new DataStore();
        Shadowrun3.initialise(store);
        DungeonsAndDragons3.initialise(store);
        
        generator = new PersonGenerator(store);
        descriptor = new PersonDescriptor();

        setLayout(new BorderLayout());

        pnlOptions = new OptionsPanel(store);
        txtArea = new JTextArea(25, 50);
        btnGenerate = new JButton("Generate");

        btnGenerate.addActionListener(event -> {
            GeneratorOptions options = pnlOptions.getSelectedOptions();
            Person person = generator.generatePerson(options);
            txtArea.setText(descriptor.generateString(person));
        });

        add(pnlOptions, BorderLayout.NORTH);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
        add(btnGenerate, BorderLayout.SOUTH);

        pack();
    }
    
    private void addMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu application = new JMenu("Application");
        JMenu help = new JMenu("Help");

        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(arg -> AboutDialog.display(this));
        exit.addActionListener(arg -> this.dispose());

        application.add(exit);
        help.add(about);
        
        bar.add(application);
        bar.add(Box.createHorizontalGlue());
        bar.add(help);

        this.setJMenuBar(bar);
    }
}
