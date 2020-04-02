package controller;

import modele.ImagePerspectivePackage;

public class LoadCommand extends ImageCommand {

    @Override
    public void executeAction(java.awt.Image img, String path) {

        ImagePerspectivePackage ipp = ImagePerspectivePackage.getInstance();
        ipp.setPathImage(path);
        ipp.setImage(img);

    }
}
