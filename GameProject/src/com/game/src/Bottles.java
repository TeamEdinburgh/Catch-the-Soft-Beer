package com.game.src;

import EntityPack.EntityA;
import EntityPack.EntityB;

import java.awt.*;
import java.util.Random;

public class Bottles extends GameObject implements EntityB {
    Random r = new Random();

    private Game game;
    private Controller c;

    private Textures tex;
    private int speed = r.nextInt(2) + 2;

    public Bottles (double x, double y, Textures tex, Controller c, Game game){
        super (x, y);
        this.tex = tex;
        this.c = c;
        this.game = game;
    }

    public void tick(){
        y += speed;

        if ( y > (Game.HEIGHT * Game.SCALE)){
            speed = r.nextInt(3) + 2;
            x = r.nextInt((Game.WIDTH * Game.SCALE)-300);
            y = -10;
            Game.DROPPED -= 100;
        }
        for (int i = 0; i < game.ea.size(); i++) {
            EntityA tempEnt = game.ea.get(i);

//            if(Physics.Collision(this, tempEnt)){
//                c.removeEntity(tempEnt);
//                c.removeEntity(this);
//                game.setBeerCollected(game.getBeerCollected() + 1);
//                game.setBeers(game.getBeers());
//            }
        }

    }

    public void render(Graphics g){
        g.drawImage(tex.bottles, (int) x, (int) y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 33, 50);
    }

    public double getY(){
        return y;
    }
    public double getX(){
        return x;
    }

}
