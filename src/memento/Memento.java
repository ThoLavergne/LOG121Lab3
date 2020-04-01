package memento;

import modele.Perspective;

import java.awt.*;

public class Memento {

    private double zoomMemorized;
    private Point translationMemorized;

    //Constructeurs
    public Memento(Perspective p){
        this.zoomMemorized = p.getZoom();
        this.translationMemorized = (Point) p.getTranslation().clone();
    }

    public Memento(double zoom, Point translation){
        this.zoomMemorized = zoom;
        this.translationMemorized = (Point) translation.clone();
    }


    //Accesseurs
    public double getZoomMemorized() {
        return this.zoomMemorized;
    }

    public Point getTranslationMemorized() {
        return (Point) translationMemorized.clone();
    }


    //Methode retournant une copie du memento
    public Memento copy(){
        return new Memento(this.zoomMemorized, (Point) this.translationMemorized.clone());
    }

}
