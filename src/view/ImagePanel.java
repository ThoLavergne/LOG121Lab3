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

    public ImagePanel(){
        System.out.println("ImagePanel cree");
    }

    //Mutateur pour la perspective et ajout du panel en tant qu'observateur
    protected void setPerspective(Perspective p){
        this.p = p;
        p.addObserver(this);
    }

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

            /*AffineTransform t = new AffineTransform();
            t.translate(x, y);

            g2D.setTransform(t);*/
            g2D.scale(zoom, zoom);
            g2D.drawImage(image,x,y,this);

        }
    }





    /**
     * Méthode qui reçoit un engin graphique, une image et 2 coordonnées de position x et y, et dessine une image
     * centrée en x et y. Il est nécessaire de faire le décalage pour centrer l'image car le méthode drawImage dessine
     * le coin superieur gauche de chaque image à la position (x,y) spécifiée
     *
     * @param g, l'engin Graphics
     * @param img, l'image
     * @param positionX, la position en x à laquelle on veut centrer l'image
     * @param positionY, la position en x à laquelle on veut centrer l'image
     */
    private void drawCenteredImage(Graphics g, Image img, int positionX, int positionY){

        //recuperer les decalages necessaire
        int decalageX = img.getWidth(null)/2;
        int decalageY = img.getHeight(null)/2;

        //dessiner l'image centree
        g.drawImage(img, positionX-decalageX, positionY-decalageY, null);
    }

    @Override
    public void update() {
        repaint();
        System.out.println("updated");
    }
}
