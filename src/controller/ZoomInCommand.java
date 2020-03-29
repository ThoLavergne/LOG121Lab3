package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class ZoomInCommand extends ZoomCommand {

    public ZoomInCommand(Perspective p) {
        super(p);
    }

    @Override
    public void executeAction() {
        p.zoomIn(incrementZoom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.zoomIn(incrementZoom);
    }
}
