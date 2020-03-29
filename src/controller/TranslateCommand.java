package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class TranslateCommand extends PerspectiveCommand {

    private static int INCREMENT_TRANSLATION = 5;

    protected int incrementTranslation = INCREMENT_TRANSLATION;

    public TranslateCommand(Perspective p) {
        super(p);
    }

    @Override
    public abstract void executeAction();

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
