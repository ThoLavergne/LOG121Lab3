package view;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class MainWindow extends JFrame/* implements PropertyChangeListener */{
    /**
     * Code inspiré de la classe FenetrePrincipale du laboratoire 1 en LOG121.
     */
    public static int TASKBAR_HEIGHT = 40;
    public static int BUFFER = 3;
    public static Dimension TAILLE_FENETRE = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - TASKBAR_HEIGHT);
    //private static final Dimension DIMENSION = new Dimension(700, 700);
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 - Application de modification de perspective";

    public MainWindow(){
        MainPanel mainPanel = new MainPanel();
        MainMenu mainMenu = new MainMenu(this);
        this.add(mainPanel);
        this.add(mainMenu, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(TAILLE_FENETRE);
        setPreferredSize(TAILLE_FENETRE);
        setVisible(true);
        //setLocationRelativeTo(null);
        setResizable(true);
        //mainMenu.addPropertyChangeListener(this);

    }
    /*@Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
        System.out.println(evt.getNewValue());
    }*/
}
