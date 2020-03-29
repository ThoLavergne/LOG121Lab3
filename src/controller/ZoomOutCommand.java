package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class ZoomOutCommand extends ZoomCommand {

    public ZoomOutCommand(Perspective p) {
        super(p);
    }

    @Override
    public void executeAction() {
        p.zoomOut(incrementZoom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.zoomOut(incrementZoom);
    }
}
