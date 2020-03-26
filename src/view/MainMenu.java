package view;

import controller.CommandManager;
import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainMenu extends JMenuBar {
    /**
     * Code inspiré / repris du Laboratoire 1 LOG121
     */
    private static final String MENU_FILE_TITLE = "File";
    private static final String MENU_FILE_OPEN = "Open";
    private static final String MENU_FILE_SAVE = "Save";
    private static final String MENU_COMMAND_TITLE = "Commands";
    private static final String MENU_COMMAND_TRANSLATE = "Translate";
    private static final String MENU__COMMAND_ZOOM = "Zoom";
    private static final String MENU_COMMAND_UNDO = "Undo";
    private static final String MENU_COMMAND_REDO = "Redo";
    private static final String MENU_FILE_EXIT = "Close";
    private static final String MENU_HELP_TITLE = "Help";
    private static final String MENU_HELP_ABOUT = "About";

    public MainMenu() {
        ajouterMenuFichier();
        addMenuCommands();
        ajouterMenuAide();
    }

    private void ajouterMenuFichier() {
        JMenu menuFichier = new JMenu(MENU_FILE_TITLE);
        JMenuItem menuCharger = new JMenuItem(MENU_FILE_OPEN);
        JMenuItem menuSave = new JMenuItem(MENU_FILE_SAVE);
        JMenuItem menuQuitter = new JMenuItem(MENU_FILE_EXIT);

        menuCharger.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Sélectionnez une photo");
            fileChooser.setAcceptAllFileFilterUsed(false);
            // Cr�er un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "xml");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    Document doc = dbFactory.newDocumentBuilder().parse(selectedFile);
                    System.out.println(selectedFile.getAbsolutePath());
                    String n = doc.getDocumentElement().getNodeName();
                    NodeList nListMetadata = doc.getElementsByTagName("metadonnees");
                    NodeList nListSimulation = doc.getElementsByTagName("simulation");


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        menuQuitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        /**
         * Save actual picture
         */
        menuSave.addActionListener((ActionEvent e) ->  {// TODO

        });
        menuFichier.add(menuSave);
        menuFichier.add(menuCharger);
        menuFichier.add(menuQuitter);

        add(menuFichier);

    }

    /**
     * Add commands Menu
     */
    private void addMenuCommands() {
        JMenu menuCommands = new JMenu(MENU_COMMAND_TITLE);
        JMenuItem commandsTranslate = new JMenuItem(MENU_COMMAND_TRANSLATE);
        JMenuItem commandsZoom = new JMenuItem(MENU__COMMAND_ZOOM);
        JMenuItem commandsUndo = new JMenuItem(MENU_COMMAND_UNDO);
        JMenuItem commandsRedo = new JMenuItem(MENU_COMMAND_REDO);
        CommandManager commandManager = CommandManager.getInstance();
        commandsTranslate.addActionListener((ActionEvent e) -> { //TODO
        });
        commandsZoom.addActionListener((ActionEvent e) -> { //TODO
        });
        commandsUndo.addActionListener((ActionEvent e) -> { //TODO
        });
        commandsRedo.addActionListener((ActionEvent e) -> { //TODO
        });
        menuCommands.add(commandsTranslate);
        menuCommands.add(commandsZoom);
        menuCommands.add(commandsUndo);
        menuCommands.add(commandsRedo);

        add(menuCommands);
    }

    /**
     * Cr�er le menu Aide
     */
    private void ajouterMenuAide() {
        JMenu menuAide = new JMenu(MENU_HELP_TITLE);
        JMenuItem menuPropos = new JMenuItem(MENU_HELP_ABOUT);
        menuAide.add(menuPropos);

        menuPropos.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,
                    "<html><p>Application de modification de perspective.</p>" + "<br>"
                            + "<p>&copy; &nbsp; 2020 &nbsp; Thomas Lavergne</p>"
                            + "<p>&copy; &nbsp; 2020 &nbsp; Charles Fleury</p>" + "<br>"
                            + "<p>&Eacute;cole de technologie sup&eacute;rieure</p></html>");
        });
        add(menuAide);
    }
}
