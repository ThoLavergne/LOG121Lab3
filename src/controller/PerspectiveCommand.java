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
        this.undoMemento.setBacktrack(backtrack);

        //On execute l'action concrete
        execute(actionEvent);
    };

    /**
     * Méthode qui gère les actions lors d'un undo command
     */
    public void undo(){

        Memento backtrack = this.redoMemento.copy();

        //l'état actuel de la perspective est sauvée dans le redo memento
        this.redoMemento = p.getMemento();

        //on sauvegarde le redomemento precedent dans le backtrack du redoMemento
        this.redoMemento.setBacktrack(backtrack);

        //la perspective est modifiée pour etre identique au courant undo memento
        p.setMemento(this.undoMemento);

        //Le undo memento devient son memento precedent
        this.undoMemento = this.undoMemento.getBacktrack();
    }

    /**
     * Méthode qui gère les actions lors d'un redo command
     */
    public void redo(){

        Memento backtrack = this.undoMemento.copy();

        //l'état actuel de la perspective est sauvée dans le undo memento
        this.undoMemento = p.getMemento();

        //on sauvegarde le redomemento precedent dans le backtrack du redoMemento
        this.undoMemento.setBacktrack(backtrack);

        //la perspective est modifiée pour etre identique au courant redo memento
        p.setMemento(this.redoMemento);

        //Le undo memento devient son memento precedent
        this.redoMemento = this.redoMemento.getBacktrack();

    }

    public abstract void execute(ActionEvent e);

}
