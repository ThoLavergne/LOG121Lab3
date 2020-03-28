package view;

import modele.ImagePerspectivePackage;
import observer.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ImagePanel extends JPanel implements MyObserver {
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Image image = ImagePerspectivePackage.getInstance().getImage();
        if(image != null) g.drawImage(image,0,0,this);
    }
    public ImagePanel(boolean dynamic){
        if (dynamic){
            panelIsDynamic();
        }
    }
    @Override
    public void update() {

    }

    private void panelIsDynamic(){
        JButton zoom = new JButton("ZOOM");
        JButton translate = new JButton("TRANSLATE");
        zoom.addActionListener((ActionEvent e) -> {
            //TODO
        });
        translate.addActionListener((ActionEvent e)-> {
            //TODO
        });
        add(zoom);
        add(translate);
    }
}
