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

    //Cette méthode sert de méthode template, appelé losqu'un évènement écouté par une PerspectiveCommand arrive
    public final void execute(){

        //On ajoute la commande a la liste de celles qu'on peut defaire
        CommandManager mngr = CommandManager.getInstance();
        mngr.addToUndo(this);

        Memento backtrack = null;
        if(this.undoMemento!= null){
            backtrack = this.undoMemento.copy();
        }

        this.undoMemento = p.getMemento();

        if(backtrack != null){
            this.undoMemento.setBacktrack(backtrack);
        }

        //On execute l'action concrete
        executeAction();
    };

    /**
     * Méthode qui gère les actions lors d'un undo command
     */
    public void undo(){

        Memento backtrack = null;
        if(this.redoMemento!=null){
            backtrack = this.redoMemento.copy();
        }

        //l'état actuel de la perspective est sauvée dans le redo memento
        this.redoMemento = p.getMemento();

        //on sauvegarde le redomemento precedent dans le backtrack du redoMemento
        if(backtrack!=null){
            this.redoMemento.setBacktrack(backtrack);
        }

        //la perspective est modifiée pour etre identique au courant undo memento
        p.setMemento(this.undoMemento);

        //Le undo memento devient son memento precedent
        if(undoMemento.getBacktrack()!=null){
            this.undoMemento = this.undoMemento.getBacktrack();
        }

    }

    /**
     * Méthode qui gère les actions lors d'un redo command
     */
    public void redo(){

        Memento backtrack = null;
        if(this.undoMemento!=null){
            backtrack = this.undoMemento.copy();
        }

        //l'état actuel de la perspective est sauvée dans le undo memento
        this.undoMemento = p.getMemento();

        if(backtrack!=null){
            this.undoMemento.setBacktrack(backtrack);
        }
        //on sauvegarde le redomemento precedent dans le backtrack du redoMemento

        //la perspective est modifiée pour etre identique au courant redo memento
        p.setMemento(this.redoMemento);

        //Le redo memento devient son memento precedent
        if(redoMemento.getBacktrack()!=null){
            this.redoMemento = this.redoMemento.getBacktrack();
        }

    }

    public abstract void executeAction();
    public abstract void actionPerformed(ActionEvent e);

}
