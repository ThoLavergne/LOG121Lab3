package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class TranslateLeftCommand extends TranslateCommand{

    public TranslateLeftCommand(Perspective p) {
        super(p);
    }

    @Override
    public void executeAction() {
        p.moveLeft(incrementTranslation);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.moveLeft(incrementTranslation);
    }


}
