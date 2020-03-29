package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class TranslateDownCommand extends TranslateCommand {

    public TranslateDownCommand(Perspective p) {
        super(p);
    }

    @Override
    public void executeAction() {
        p.moveDown(incrementTranslation);
        System.out.println("move down");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.moveDown(incrementTranslation);
    }
}
