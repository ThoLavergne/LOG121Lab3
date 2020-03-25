package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class ImageCommand extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e){
        execute();
    }

    public abstract void execute();
}
