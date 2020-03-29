package modele;

import memento.Memento;
import observer.MyObservable;
import observer.MyObserver;

import java.awt.*;
import java.util.ArrayList;

public class Perspective implements MyObservable {

    private double zoom = 1;
    private Point translation = new Point(0,0);
    private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public Perspective(){}

    public Perspective(double zoom, Point translation){
        this.zoom = zoom;
        this.translation = translation;
    }

    /**
     * Méthode qui avertit tous les observers
     */
    @Override
    public void notifyObservers() {
        for (MyObserver o : observers){
            o.update();
        }
    }

    /**
     * Méthode qui ajoute un observer
     * @param obs
     */
    @Override
    public void addObserver(MyObserver obs) {
        observers.add(obs);
    }

    /**
     * Méthode qui retire un observer
     * @param obs
     */
    @Override
    public void removeObserver(MyObserver obs){
        observers.remove(obs);
    }

    //Accesseurs et mutateurs
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

    public int getX(){
        return this.translation.x;
    }

    public int getY(){
        return this.translation.y;
    }

    //Méthode qui retourne le memento de cette perspective
    public Memento getMemento(){
        return new Memento(this);
    }

    //Méthode qui pose cette perspective à une version antérieure
    public void setMemento(Memento mem){
        this.zoom = mem.getZoomMemorized();
        this.translation = (Point) mem.getTranslationMemorized().clone();
        System.out.println("Memento: \n Zoom: "+zoom );
        notifyObservers();
    }

    //Méthodes de zoom
    public void zoomIn(double increment){
        this.zoom += increment;
        System.out.println("Zoom In: "+ zoom);
        notifyObservers();

    }

    public void zoomOut(double increment){
        this.zoom -= increment;
        System.out.println("Zoom Out: "+ zoom);
        notifyObservers();
    }

    //Méthodes de translation

    public void moveLeft(int increment){
        this.translation.translate(-increment, 0);
        System.out.print("X: "+ translation.x+ "*** Y: "+ translation.y);
        notifyObservers();
    }

    public void moveRight(int increment){
        this.translation.translate(increment, 0);
        System.out.print("X: "+ translation.x+ "*** Y: "+ translation.y);
        notifyObservers();
    }

    public void moveUp(int increment){
        this.translation.translate(0, -increment);
        System.out.print("X: "+ translation.x+ "*** Y: "+ translation.y);
        notifyObservers();
    }

    public void moveDown(int increment){
        this.translation.translate(0, increment);
        System.out.print("X: "+ translation.x+ "*** Y: "+ translation.y);
        notifyObservers();
    }

}
