package modele;

import java.io.*;
import java.util.ArrayList;

public class ImagePerspectivePackage {

    Image image;
    ArrayList<Perspective> perspectives;


    public void serialize(String path){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in" + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserialize(String path){
        ImagePerspectivePackage i = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            i = (ImagePerspectivePackage) in.readObject();
            in.close();
            fileIn.close();
            this.image = i.getImage();
            this.perspectives = i.getPerspectives();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("ImagePerspectivePackage class not found");
            c.printStackTrace();
        }
    }

    //Accesseurs et mutateurs
    public Image getImage(){
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Perspective> getPerspectives(){
        return (ArrayList<Perspective>) this.perspectives.clone();
    }

    public void setPerspectives(ArrayList<Perspective> perspectives) {
        this.perspectives = (ArrayList<Perspective>) perspectives.clone();
    }
}
