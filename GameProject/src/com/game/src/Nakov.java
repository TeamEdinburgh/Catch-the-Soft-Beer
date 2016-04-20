package com.game.src;


import javafx.animation.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

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
        if ( game.level == 1)
        g.drawImage(tex.nakov[0], (int)x, (int)y ,null);
        else if(game.level == 2)
            g.drawImage(tex.nakov[1], (int)x, (int)y ,null);
        else if(game.level == 3)
            g.drawImage(tex.nakov[2], (int)x, (int)y ,null);
        else if(game.level == 4)
            g.drawImage(tex.nakov[3], (int)x, (int)y ,null);
        else
            g.drawImage(tex.nakov[3], (int)x, (int)y ,null);

    }
}
