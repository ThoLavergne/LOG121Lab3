package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class TranslateUpCommand extends TranslateCommand {

    public TranslateUpCommand(Perspective p) {
        super(p);
    }

    @Override
    public void executeAction() {
        p.moveUp(incrementTranslation);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.moveUp(incrementTranslation);
    }
}
