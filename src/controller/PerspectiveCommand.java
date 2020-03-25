package controller;

import memento.Memento;
import modele.Perspective;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class PerspectiveCommand extends AbstractAction {

    /*La commande garde 2 mementos, un si l'usager veut redo et l'autre s'il veut undo
    Il est necessaire d'avoir les 2 car l'usager qui a fait un undo a l'option de
    faire soit un redo ou undo ensuite*/
    private Memento undoMemento;
    private Memento redoMemento;
    private Perspective p;


    //Cette méthode sert de méthode template, appelé losqu'un évènement écouté par une PerspectiveCommand arrive
    @Override
    public final void actionPerformed(ActionEvent actionEvent){

        //On ajoute la commande a la liste de celles qu'on peut defaire
        CommandManager mngr = CommandManager.getInstance();
        mngr.addToUndo(this);

        Memento backtrack = this.undoMemento.copy();
        this.undoMemento = p.getMemento();



        //On execute l'action concrete
        execute();
    };


    public void undo(){

    }

    public void redo(){

    }

    public abstract void execute();

}
