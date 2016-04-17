package com.game.src;

import EntityPack.EntityB;

import java.awt.*;
import java.util.Random;

public class Bottles extends GameObject implements EntityB {
    Random r = new Random();

    private Textures tex;
    private int speed = r.nextInt(3) + 1;

    public Bottles (double x, double y, Textures tex){
        super (x, y);
        this.tex = tex;
    }

    public void tick(){
        y += speed;

        if ( y > (Game.HEIGHT * Game.SCALE)){
            speed = r.nextInt(3) + 1;
            x = r.nextInt(Game.WIDTH * Game.SCALE);
            y = 0;
        }
    }

    public void render(Graphics g){

        g.drawImage(tex.bottles, (int) x, (int) y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 64, 64);
    }

    public double getY(){
        return y;
    }
    public double getX(){
        return x;
    }

}
