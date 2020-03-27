package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoCommand extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        CommandManager mngr = CommandManager.getInstance();

        if(!mngr.isRedoEmpty()){
            //enlever la commande de la liste de commandes qu'on peut defaire
            PerspectiveCommand command = mngr.removeFromRedo();
            //rajouter la commande à la liste qu'on peut refaire
            mngr.addToRedo(command);
            //executer undo de PerspectiveCommand
            command.undo();
        }
    }
}
