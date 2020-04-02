package modele;

import observer.MyObservable;
import observer.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;

public class ImagePerspectivePackage implements Serializable, MyObservable {
    private static int NB_PERSPECTIVES = 3;

    //Singleton
    private static ImagePerspectivePackage ipp = new ImagePerspectivePackage(NB_PERSPECTIVES);

    private transient java.awt.Image image = null;
    private String pathImage;
    private ArrayList<Perspective> perspectives = new ArrayList<>();
    private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
    private boolean imageLoaded = false;


    //Constructeur privé
    private ImagePerspectivePackage(int nbPerspectives) {

        //On cree le nb de perspectives spécifié
        for (int i = 0; i < nbPerspectives; i++) {
            perspectives.add(new Perspective());
        }
    }

    /**
     * Méthode qui sérialize cet objet et le sauvegarde dans le path en parametre
     *
     * @param path inspiré de https://www.tutorialspoint.com/java/java_serialization.htm
     */
    public void serialize(String path) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.getInstance());
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in" + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Méthode qui desérialize l'objet sauvegarde dans le path en parametre
     *
     * @param path inspiré de https://www.tutorialspoint.com/java/java_serialization.htm
     */
    public void deserialize(String path) {
        ImagePerspectivePackage i = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            i = (ImagePerspectivePackage) in.readObject();
            in.close();
            fileIn.close();
            this.setPathImage(i.getPathImage());
            System.out.println(this.getPathImage());

            this.setPerspectives(i.getPerspectives());
            ImageIcon imageIcon = new ImageIcon(i.getPathImage());
            this.setImage(imageIcon.getImage());

            //on avertit le main panel de la deserialization, qui réassignera les vues aux nouvelles perspectives
            notifyObservers();

            //les perspectives avertissent leur vue de leur état
            for (Perspective p : perspectives) {
                p.notifyObservers();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("ImagePerspectivePackage class not found");
            c.printStackTrace();
        }
    }

    //Accesseurs et mutateurs
    public java.awt.Image getImage() {
        return this.image;
    }

    public void setImage(java.awt.Image image) {
        this.image = image;
        this.imageLoaded = true;

        for (Perspective p : this.perspectives) {
            p.notifyObservers();
        }
    }

    public ArrayList<Perspective> getPerspectives() {
        return (ArrayList<Perspective>) this.perspectives.clone();
    }

    public void setPerspectives(ArrayList<Perspective> perspectives) {
        this.perspectives = (ArrayList<Perspective>) perspectives.clone();
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }

    //Accesseur d'une perspective en particulier selon l'index
    public Perspective getPerspective(int index) {
        ArrayList<Perspective> perspectives = (ArrayList<Perspective>) this.perspectives.clone();
        return perspectives.get(index);
    }

    //Accesseur du singleton
    public static ImagePerspectivePackage getInstance() {
        return ipp;
    }

    //Méthodes sujet observer

    /**
     * Méthode qui avertit tous les observers
     */
    @Override
    public void notifyObservers() {
        for (MyObserver o : observers) {
            o.update();
        }
    }

    /**
     * Méthode qui ajoute un observer
     *
     * @param obs
     */
    @Override
    public void addObserver(MyObserver obs) {
        observers.add(obs);
    }

    /**
     * Méthode qui retire un observer
     *
     * @param obs
     */
    @Override
    public void removeObserver(MyObserver obs) {
        observers.remove(obs);
    }
}

