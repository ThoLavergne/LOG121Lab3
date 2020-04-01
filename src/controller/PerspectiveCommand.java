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
    protected Perspective p;


    //Constructeur
    public PerspectiveCommand(Perspective p){
        this.p = p;
    }

    //Cette méthode sert de méthode template, appelé losqu'un évènement écouté par une PerspectiveCommand se deroule
    public final void execute(){

        //On ajoute la commande a la liste de celles qu'on peut defaire
        CommandManager mngr = CommandManager.getInstance();
        mngr.addToUndo(this);

        this.undoMemento = p.getMemento();

        //On execute l'action concrete
        executeAction();
    };

    /**
     * Méthode qui gère les actions lors d'un undo command
     */
    public void undo(){

        //l'état actuel de la perspective est sauvée dans le redo memento
        this.redoMemento = p.getMemento();


        //la perspective est modifiée pour etre identique au courant undo memento
        p.setMemento(this.undoMemento);

    }

    /**
     * Méthode qui gère les actions lors d'un redo command
     */
    public void redo(){

        //l'état actuel de la perspective est sauvée dans le undo memento
        this.undoMemento = p.getMemento();

        //la perspective est modifiée pour etre identique au courant redo memento
        p.setMemento(this.redoMemento);

    }

    public abstract void executeAction();
    public abstract void actionPerformed(ActionEvent e);

}
