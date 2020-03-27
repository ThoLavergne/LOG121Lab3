package controller;

import modele.ImagePerspectivePackage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class IPPCommand extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        execute();
    }

    public abstract void execute();

}
