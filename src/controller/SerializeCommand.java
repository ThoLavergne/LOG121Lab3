package controller;

import modele.ImagePerspectivePackage;

import java.awt.event.ActionEvent;

public class SerializeCommand extends IPPCommand {

    @Override
    public void executeAction() {
        ImagePerspectivePackage.getInstance().serialize("save.ser");
    }
}
