package view;

import controller.*;
import modele.Perspective;
import observer.MyObserver;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import static view.MainWindow.BUFFER;
import static view.MainWindow.TAILLE_FENETRE;

public class DualPanel extends JPanel {

    private static int BUTTON_BAR_HEIGHT = 30;
    private static int PANEL_WIDTH = TAILLE_FENETRE.width/2 - 6*BUFFER;
    private static int BIG_DYNAMIC_IMAGE_HEIGHT = (TAILLE_FENETRE.height) - BUTTON_BAR_HEIGHT-(2*BUFFER);
    private static int SMALL_DYNAMIC_IMAGE_HEIGHT = (TAILLE_FENETRE.height/2) - BUTTON_BAR_HEIGHT-(16*BUFFER);
    private static int STATIC_IMAGE_HEIGHT = (TAILLE_FENETRE.height/2)-(16*BUFFER);

    ImagePanel imagePanel;
    JPanel buttonPanel;
    Perspective p;
    Point mousePoint, origine;
    int dx, dy;
    //Constructeur
    public DualPanel(boolean dynamic, boolean big){

        if (dynamic){
            panelIsDynamic(big);
        }
        else{
            panelIsStatic();
        }

        setVisible(true);
    }

    //Mutateur pour la perspective de ce panel, qui enverra les commande, et de l'imagePanel qui dessinera
    protected void setImagePerspective(Perspective p){

        //On definit la perspective de ce panel
        this.p = p;

        //On defnit la perspective de l'ImagePanel
        imagePanel.setPerspective(p);

    }



    /**
     * Méthode appelée si le panel est dynamique
     * On crée un panel de boutons et on ajuste la grandeur du panel image
     */
    private void panelIsDynamic(boolean big){

        System.out.println("Panel dynamique");
        imagePanel = new ImagePanel();
        buttonPanel = new JPanel();

        JButton zoomIn = new JButton("ZOOM +");
        JButton zoomOut = new JButton("ZOOM -");
        JButton translateUp = new JButton("UP");
        JButton translateDown = new JButton("DOWN");
        JButton translateLeft = new JButton("LEFT");
        JButton translateRight = new JButton("RIGHT");
        //Listeners sur les boutons
        zoomIn.addActionListener((ActionEvent e) -> {
            PerspectiveCommand c = new ZoomInCommand(this.p);
            c.execute();
        });
        zoomOut.addActionListener((ActionEvent e) -> {
            PerspectiveCommand c = new ZoomOutCommand(this.p);
            c.execute();
        });

        translateUp.addActionListener((ActionEvent e)-> {


            PerspectiveCommand c = new TranslateFreeCommand(this.p, 0,-5);
            c.execute();
        });

        translateLeft.addActionListener((ActionEvent e)-> {
            PerspectiveCommand c = new TranslateFreeCommand(this.p, -5,0);
            c.execute();
        });
        translateRight.addActionListener((ActionEvent e)-> {
            PerspectiveCommand c = new TranslateFreeCommand(this.p,5,0);
            c.execute();
        });
        translateDown.addActionListener((ActionEvent e)-> {
            PerspectiveCommand c = new TranslateFreeCommand(this.p,0,5);
            c.execute();
        });


        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setPreferredSize(new Dimension(PANEL_WIDTH, BUTTON_BAR_HEIGHT));
        //buttonPanel.setBackground(Color.pink);
        buttonPanel.add(zoomIn);
        buttonPanel.add(zoomOut);
        buttonPanel.add(translateLeft);
        buttonPanel.add(translateUp);
        buttonPanel.add(translateDown);
        buttonPanel.add(translateRight);

        if(big){
            imagePanel.setPreferredSize(new Dimension(PANEL_WIDTH, BIG_DYNAMIC_IMAGE_HEIGHT));
        }
        else{
            imagePanel.setPreferredSize(new Dimension(PANEL_WIDTH, SMALL_DYNAMIC_IMAGE_HEIGHT));
        }

        //Zoom avec la roulette
        imagePanel.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {

                if (e.getPreciseWheelRotation() < 0) {
                    PerspectiveCommand c = new ZoomInCommand(p);
                    c.execute();
                } else {
                    PerspectiveCommand c = new ZoomOutCommand(p);
                    c.execute();
                }
            }
        });

        imagePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePoint = e.getPoint();
                origine = new Point(e.getX(),e.getY());
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                p.move(-dx,-dy);
                PerspectiveCommand c = new TranslateFreeCommand(p,dx,dy);
                c.execute();
                mousePoint = e.getPoint();
                repaint();
                dx = dy = 0;
            }
        });

        imagePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                 dx += e.getX() - mousePoint.x;
                 dy += e.getY() - mousePoint.y;

                p.move(e.getX() - mousePoint.x,e.getY() - mousePoint.y);
                mousePoint = e.getPoint();
                repaint();

            }

        });

        //TODO- Ajouter un Listener qui envoie des translate command selon le drag
        //imagePanel.addXYZlistener

        add(buttonPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.SOUTH);



        buttonPanel.setVisible(true);
        imagePanel.setVisible(true);
    }

    /**
     * Méthode appelée si le panel est statique (thumbnail)
     * le panel image remplit tout ce panel
     */
    private void panelIsStatic(){

        imagePanel = new ImagePanel();

        imagePanel.setPreferredSize(new Dimension(PANEL_WIDTH, STATIC_IMAGE_HEIGHT));

        //Border blackline = BorderFactory.createLineBorder(Color.black,5);

        //imagePanel.setBorder(blackline);

        add(imagePanel);

        imagePanel.setVisible(true);
    }
}
