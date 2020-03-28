package view;

import modele.ImagePerspectivePackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import static view.MainWindow.TAILLE_FENETRE;

public class MainPanel extends JPanel {

    public MainPanel(){

        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        ImagePanel panelGauche = new ImagePanel(true);
        JPanel panelDroite = new JPanel();
        ImagePanel panel2 = new ImagePanel(true);
        ImagePanel panel3 = new ImagePanel(false);

        panelGauche.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2, TAILLE_FENETRE.height));
        panelDroite.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2, TAILLE_FENETRE.height));
        panel2.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2, TAILLE_FENETRE.height/2));
        panel3.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2, TAILLE_FENETRE.height/2));
//        panelGauche.setBackground(Color.BLUE);
//        panel2.setBackground(Color.RED);
//        panel3.setBackground(Color.GREEN);

        panelDroite.setVisible(true);
        panelGauche.setVisible(true);
        panel2.setVisible(true);
        panel3.setVisible(true);

        panelDroite.add(panel2, BorderLayout.NORTH);
        panelDroite.add(panel3, BorderLayout.SOUTH);

        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroite, BorderLayout.EAST);


        setVisible(true);

    }
    public void setImage(java.awt.Image image){

    }
}
