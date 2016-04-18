package com.game.src;


import EntityPack.EntityA;
import EntityPack.EntityB;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements EntityA {

    private double velX = 0;

    private BufferedImage player;
    private Game game;
    private Controller controller;

    private Textures tex;

    public Player(double x , double y, Textures tex, Game game, Controller controller){
        super(x, y);
        this.tex = tex;
        this.controller = controller;
        this.game = game;

    }

    public void tick(){
        x += velX;

        if (x <= -10)
            x = -10;

        if (x >= 640)
            x = 640;

        for (int i = 0; i < game.eb.size(); i++) {
            EntityB tempEnt = game.eb.get(i);

            if (Physics.Collision(this, tempEnt)) {
                controller.removeEntity(tempEnt);
                Game.HEALTH -= 10;
                game.setBeerCollected(game.getBeerCollected() + 1);
            }
        }

    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 175, 200);
    }

    public void render(Graphics g){

        g.drawImage(tex.player, (int)x, (int)y ,null);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public void setVelX(double velX){

        this.velX = velX;
    }
}
