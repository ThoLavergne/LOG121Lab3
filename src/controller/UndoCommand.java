package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoCommand extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        CommandManager mngr = CommandManager.getInstance();

        if(!mngr.isUndoEmpty()){
            //enlever la commande de la liste de commandes qu'on peut defaire
            PerspectiveCommand command = mngr.removeFromUndo();
            //rajouter la commande à la liste qu'on peut refaire
            mngr.addToRedo(command);
            //executer undo de PerspectiveCommand
            command.undo();
        }
    }
}
