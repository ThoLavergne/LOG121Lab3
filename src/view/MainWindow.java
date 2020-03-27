package view;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
    /**
     * Code inspiré de la classe FenetrePrincipale du laboratoire 1 en LOG121.
     */
    public static Dimension TAILLE_FENETRE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Dimension DIMENSION = new Dimension(700, 700);
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 - Application de modification de perspective";
    public MainWindow(){
        MainPanel mainPanel = new MainPanel();
        MainMenu mainMenu = new MainMenu();
        this.add(mainPanel);
        this.add(mainMenu, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(TAILLE_FENETRE);
        setPreferredSize(TAILLE_FENETRE);
        setVisible(true);
        //setLocationRelativeTo(null);
        setResizable(true);


    }
}
