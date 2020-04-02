package controller;

import modele.Perspective;

import java.awt.event.ActionEvent;

public class TranslateFreeCommand extends TranslateCommand {

    int x , y ;
    public TranslateFreeCommand(Perspective p,int x, int y){
        super(p);
        this.x = x;
        this.y = y;
    }
    @Override
    public void executeAction() {
        p.move(x,y);
    }
}
