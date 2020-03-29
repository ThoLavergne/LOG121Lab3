package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class TranslateRightCommand extends TranslateCommand{

    public TranslateRightCommand(Perspective p) {
        super(p);
    }

    @Override
    public void executeAction() {
        p.moveRight(incrementTranslation);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.moveRight(incrementTranslation);
    }
}
