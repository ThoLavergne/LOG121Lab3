package modele;

import memento.Memento;
import observer.MyObservable;
import observer.MyObserver;

import java.awt.*;
import java.util.ArrayList;

public class Perspective implements MyObservable {

    private double zoom;
    private Point translation;
    private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public Perspective(){}

    public Perspective(double zoom, Point translation){
        this.zoom = zoom;
        this.translation = translation;
    }

    @Override
    public void notifyObservers() {
        for (MyObserver o : observers){
            o.update();
        }
    }

    @Override
    public void addObserver(MyObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(MyObserver obs){
        observers.remove(obs);
    }

    public double getZoom(){
        return this.zoom;
    }

    public void setZoom(double zoom){
        this.zoom = zoom;
    }

    public Point getTranslation(){
        return this.translation;
    }

    public void setTranslation(Point translation){
        this.translation = translation;
    }

    //Méthode qui retourne le memento de cette perspective
    public Memento getMemento(){
        return new Memento(this);
    }

    //Méthode qui pose cette perspective à une version antérieure
    public void setMemento(Memento mem){
        this.zoom = mem.getZoomMemorized();
        this.translation = mem.getTranslationMemorized();
    }

}
