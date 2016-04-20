package com.game.src;


import java.awt.*;

public class Nakov extends GameObject{

    private Textures tex;
    private Game game;

    public Nakov(double x , double y, Textures tex, Game game, Controller controller){
        super(x,y);
        this.tex = tex;
        this.game = game;
    }

    public void tick(){


    }

    public void render(Graphics g){

        g.drawImage(tex.nakov, (int)x, (int)y ,null);

    }
}
