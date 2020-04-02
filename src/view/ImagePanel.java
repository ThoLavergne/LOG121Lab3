package view;

import modele.ImagePerspectivePackage;
import modele.Perspective;
import observer.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;

public class ImagePanel extends JPanel implements MyObserver {

    Perspective p;

    //Mutateur pour la perspective et ajout du panel en tant qu'observateur
    protected void setPerspective(Perspective p){
        this.p = p;
        p.addObserver(this);
    }

    /**Méthode de dessin du panel
     Inspiré de http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/CreatingaImageZoomerusingGraphics2D.htm?fbclid=IwAR3H0XkaU_pOumKDNQK8ZnWk0o_uJ4OUuJUfoHVft499EXsNoQh_f14OVcA
     et de http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/TranslatingaDrawnImage.htm?fbclid=IwAR241Z8s8-yG2od6n7G_T7ukHwBNkl0tpw_I-ZULeOk7k0Zueej5d_9MuHc
     *
     */

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        Image image = ImagePerspectivePackage.getInstance().getImage();

        Point translation = p.getTranslation();

        if(image != null){

            double zoom = p.getZoom();
            int x = p.getX();
            int y = p.getY();

            g2D.scale(zoom, zoom);
            g2D.drawImage(image,x,y,this);

        }
    }


    //On repaint le panel lors de la mise à jour de clenchée par la perspective
    @Override
    public void update() {
        repaint();
    }
}
