package controller;

import modele.ImagePerspectivePackage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class IPPCommand extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        executeAction();
    }

    public abstract void executeAction();

}
