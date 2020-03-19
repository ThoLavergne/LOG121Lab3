package modele;

import observer.MyObservable;
import observer.MyObserver;

import java.awt.*;

public class Perspective implements MyObservable {

    private double zoom;
    private Point tranlation;

    @Override
    public void notifyObservers() {

    }

    @Override
    public void addObserver(MyObserver obs) {

    }

    @Override
    public void removeObserver(MyObserver obs) {

    }
}
