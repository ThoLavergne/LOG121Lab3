package view;

import controller.*;
import modele.ImagePerspectivePackage;
import org.w3c.dom.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainMenu extends JMenuBar {
    /**
     * Code inspiré / repris du Laboratoire 1 LOG121
     */
    private static final String MENU_FILE_TITLE = "File";
    private static final String MENU_FILE_OPEN_IMAGE = "Open Image";
    private static final String MENU_FILE_OPEN_FILE = "Open File";
    private static final String MENU_FILE_SAVE = "Save";
    private static final String MENU_COMMAND_TITLE = "Commands";
    private static final String MENU_COMMAND_TRANSLATE = "Translate";
    private static final String MENU__COMMAND_ZOOM = "Zoom";
    private static final String MENU_COMMAND_UNDO = "Undo";
    private static final String MENU_COMMAND_REDO = "Redo";
    private static final String MENU_FILE_EXIT = "Close";
    private static final String MENU_HELP_TITLE = "Help";
    private static final String MENU_HELP_ABOUT = "About";
    private MainWindow parent;
    public MainMenu(MainWindow parent) {
        this.parent = parent;
        ajouterMenuFichier();
        addMenuCommands();
        ajouterMenuAide();
    }

    private void ajouterMenuFichier() {
        JMenu menuFichier = new JMenu(MENU_FILE_TITLE);
        JMenuItem menuChargerImage = new JMenuItem(MENU_FILE_OPEN_IMAGE);
        JMenuItem menuChargerFichier = new JMenuItem(MENU_FILE_OPEN_FILE);
        JMenuItem menuSave = new JMenuItem(MENU_FILE_SAVE);
        JMenuItem menuQuitter = new JMenuItem(MENU_FILE_EXIT);

        ImagePerspectivePackage perspectivePackage = ImagePerspectivePackage.getInstance();

        menuChargerImage.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Sélectionnez une photo");
            fileChooser.setAcceptAllFileFilterUsed(false);
            // Cr�er un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png ou .jpg", "png", "jpg");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(selectedFile);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    System.out.println("Appel de la LoadCommand");
                    //Appel de la LoadCommand
                    ImageCommand ic = new LoadCommand();
                    ic.execute(img);
                    System.out.println("Loadcommand executée");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            firePropertyChange("New Image",null,"New Image");
//            MainPanel mainPanel = new MainPanel();
//            System.out.println(this.parent);
//            this.parent.add(mainPanel);
        });

        menuQuitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        menuChargerFichier.addActionListener((ActionEvent e) ->  {// TODO DeSerialization
          //  perspectivePackage.deserialize();
        });

        /**
         * Save actual picture
         */
        menuSave.addActionListener((ActionEvent e) ->  {// TODO Serialization
       //     perspectivePackage.serialize();
        });

        menuFichier.add(menuSave);
        menuFichier.add(menuChargerImage);
        menuFichier.add(menuChargerFichier);
        menuFichier.add(menuQuitter);

        add(menuFichier);

      // this.getParent().add()
    }

    /**
     * Méthode pour récupérer un fichier : ajouter moyen de choisir entre image et fichier afin de différencier les deux.
     * @return path
     */
    public String openFile(){
        return null;

    }
    /**
     * Add commands Menu
     */
    private void addMenuCommands() {
        JMenu menuCommands = new JMenu(MENU_COMMAND_TITLE);
        JMenuItem commandsUndo = new JMenuItem(MENU_COMMAND_UNDO);
        JMenuItem commandsRedo = new JMenuItem(MENU_COMMAND_REDO);
        commandsUndo.addActionListener(new UndoCommand());
        commandsRedo.addActionListener(new RedoCommand());
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

    private void addCommandKeyboard(){

    }
}