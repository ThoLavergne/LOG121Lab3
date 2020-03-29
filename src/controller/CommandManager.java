package controller;

import java.util.ArrayList;

public class CommandManager {

    private static CommandManager mngr = new CommandManager();
    private ArrayList undoCommands = new ArrayList<PerspectiveCommand>();
    private ArrayList redoCommands = new ArrayList<PerspectiveCommand>();

    //constructeur privé pour singleton
    private CommandManager(){};

    //Méthode d'accès au singleton
    public static CommandManager getInstance(){
        return mngr;
    };

    public PerspectiveCommand removeFromUndo(){
        return (PerspectiveCommand) undoCommands.remove(0);

    }

    public PerspectiveCommand removeFromRedo(){
        return (PerspectiveCommand) redoCommands.remove(0);
    }

    public void addToUndo(PerspectiveCommand command){
        undoCommands.add(0, command);
    }

    public void addToRedo(PerspectiveCommand command){
        redoCommands.add(0, command);
    }

    public boolean isUndoEmpty(){
        return undoCommands.isEmpty();
    }

    public boolean isRedoEmpty(){
        return redoCommands.isEmpty();
    }

    //TEST
    public int getRedoLenght(){
        return redoCommands.size();
    }

    public int getUndoLenght(){
        return undoCommands.size();
    }


}
