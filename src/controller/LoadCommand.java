package controller;

import modele.ImagePerspectivePackage;

public class LoadCommand extends ImageCommand {

    @Override
    public void execute(java.awt.Image img) {

        ImagePerspectivePackage ipp = ImagePerspectivePackage.getInstance();

        ipp.setImage(img);

    }
}
