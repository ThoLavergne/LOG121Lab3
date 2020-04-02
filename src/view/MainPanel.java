package view;

import modele.ImagePerspectivePackage;
import observer.MyObserver;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static view.MainWindow.BUFFER;
import static view.MainWindow.TAILLE_FENETRE;

public class MainPanel extends JPanel implements MyObserver {

    DualPanel panelGauche;
    DualPanel panel2;
    DualPanel panel3;
    JPanel panelDroite;

    public MainPanel(){

        //on recupere le singleton du modele
        ImagePerspectivePackage ipp = ImagePerspectivePackage.getInstance();

        //Ajout de ce panel en observer de l'ImagePerspectivePackage, utilise lors de la deserialization
        ipp.addObserver(this);

        setLayout(new BorderLayout());
        panelGauche = new DualPanel(true, true);
        panelDroite = new JPanel();
        panel2 = new DualPanel(true, false);
        panel3 = new DualPanel(false, false);

        panelGauche.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2 - (4*BUFFER), TAILLE_FENETRE.height));
        panelDroite.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2 -(4*BUFFER), TAILLE_FENETRE.height));
        panel2.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2, TAILLE_FENETRE.height/2 -BUFFER*8));
        panel3.setPreferredSize(new Dimension(TAILLE_FENETRE.width/2, TAILLE_FENETRE.height/2 - (BUFFER*8)));

        //ajout en tant qu'observateur
        panelGauche.setImagePerspective(ipp.getPerspective(0));
        panel2.setImagePerspective(ipp.getPerspective(1));
        panel3.setImagePerspective(ipp.getPerspective(2));

        /*Border blackline = BorderFactory.createLineBorder(Color.black,2);
        panelGauche.setBorder(blackline);
        panelDroite.setBorder(blackline);*/

        panelDroite.setLayout(new BorderLayout());
        panelDroite.add(panel2, BorderLayout.NORTH);
        panelDroite.add(panel3, BorderLayout.SOUTH);



        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroite, BorderLayout.EAST);


        panelDroite.setVisible(true);
        panelGauche.setVisible(true);
        panel2.setVisible(true);
        panel3.setVisible(true);
        setVisible(true);

    }


    //redefinition des vues lors d'une deserialization
    @Override
    public void update() {
        //on recupere le singleton du modele
        ImagePerspectivePackage ipp = ImagePerspectivePackage.getInstance();

        panelGauche.setImagePerspective(ipp.getPerspective(0));
        panel2.setImagePerspective(ipp.getPerspective(1));
        panel3.setImagePerspective(ipp.getPerspective(2));
    }
}
