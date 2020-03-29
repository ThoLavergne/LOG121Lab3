package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoCommand extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        CommandManager mngr = CommandManager.getInstance();

        System.out.println("REDO");

        System.out.println("Avant: "+mngr.getRedoLenght());
        if(!mngr.isRedoEmpty()){
            System.out.println("REDO possible");
            //enlever la commande de la liste de commandes qu'on peut defaire
            PerspectiveCommand command = mngr.removeFromRedo();
            //rajouter la commande à la liste qu'on peut refaire
            mngr.addToUndo(command);
            //executer undo de PerspectiveCommand
            command.redo();
        }
        else{
            System.out.println("REDO vide");
        }
        System.out.println("Apres: "+mngr.getRedoLenght());
    }
}
