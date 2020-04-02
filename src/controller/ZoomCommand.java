package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ZoomCommand extends PerspectiveCommand{

    private static double INCREMENT_ZOOM = 0.05D;

    protected double incrementZoom = INCREMENT_ZOOM;

    public ZoomCommand(Perspective p) {
        super(p);
    }

    @Override
    public abstract void executeAction();

}
