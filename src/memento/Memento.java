package memento;

import modele.Perspective;

import java.awt.*;

public class Memento {

    private double zoomMemorized;
    private Point translationMemorized;
    //Chaque memento a son backtrack, un memento qui contient l'état qui le précédait
    //Cela crée une liste chaînée de memento, qui permet de faire plusieurs "undos" successifs
    private Memento backtrack;

    //Constructeurs
    public Memento(Perspective p){
        this.zoomMemorized = p.getZoom();
        this.translationMemorized = (Point) p.getTranslation().clone();
        this.backtrack = null;
    }

    public Memento(Perspective p, Memento mem){
        this.zoomMemorized = p.getZoom();
        this.translationMemorized = (Point) p.getTranslation().clone();
        this.backtrack = mem.copy();
    }

    public Memento(double zoom, Point translation){
        this.zoomMemorized = zoom;
        this.translationMemorized = (Point) translation.clone();
        this.backtrack = null;
    }

    public Memento(double zoom, Point translation, Memento mem){
        this.zoomMemorized = zoom;
        this.translationMemorized = (Point) translation.clone();
        this.backtrack = mem.copy();
    }

    //Accesseurs
    public double getZoomMemorized() {
        return this.zoomMemorized;
    }

    public Point getTranslationMemorized() {
        return (Point) translationMemorized.clone();
    }

    public Memento getBacktrack(){
        return this.backtrack.copy();
    }

    //Methode retournant une copie du memento
    public Memento copy(){
        if(this.backtrack != null){
            return new Memento(this.zoomMemorized, (Point) this.translationMemorized.clone(), this.backtrack.copy());
        }
        else{
            return new Memento(this.zoomMemorized, (Point) this.translationMemorized.clone());
        }
    }

    //Methode qui pose le backtrack de ce memento
    public void setBacktrack(Memento backtrack){
        this.backtrack = backtrack.copy();
    }
}
