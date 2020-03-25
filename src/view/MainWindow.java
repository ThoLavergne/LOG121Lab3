package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    /**
     * Code inspiré de la classe FenetrePrincipale du laboratoire 1 en LOG121.
     */
    private static final Dimension DIMENSION = new Dimension(700, 700);
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 - Application de modification de perspective";
    public MainWindow(){
        MainPanel mainPanel = new MainPanel();
        MainMenu mainMenu = new MainMenu();
        add(mainPanel);
        add(mainMenu, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(DIMENSION);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
