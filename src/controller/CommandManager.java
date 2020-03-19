package controller;

import java.util.ArrayList;

public class CommandManager {

    private static CommandManager mngr = getInstance();
    private ArrayList commands = new ArrayList();

    private CommandManager(){};

    public static CommandManager getInstance(){
        return mngr;
    };

    public void undo(){

    }

    public void redo(){

    }


}
