package com.game.src;

import java.awt.*;
import java.util.Random;

public class Bottles implements Entity {
    private double x;
    private double y;
    Random r = new Random();

    private Textures tex;


    public Bottles (double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    public void tick(){
        y += 3;

        if ( y > (Game.HEIGHT * Game.SCALE)){
            y = 0;
            x = r.nextInt(Game.WIDTH * Game.SCALE);
        }
    }

    public void render(Graphics g){

        g.drawImage(tex.bottles, (int) x, (int) y, null);
    }

    public double getY(){
        return y;
    }
    public double getX(){
        return x;
    }

}
