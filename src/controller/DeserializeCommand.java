package controller;

import modele.ImagePerspectivePackage;

import java.awt.event.ActionEvent;

public class DeserializeCommand extends IPPCommand {

    @Override
    public void executeAction() {
        ImagePerspectivePackage.getInstance().deserialize("save.ser");
    }
}
