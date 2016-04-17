package com.game.src;


import EntityPack.EntityA;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements EntityA {

    private double velX = 0;

    private BufferedImage player;
    private Game game;


    private Textures tex;

    public Player(double x , double y, Textures tex, Game game){
        super(x, y);
        this.tex = tex;
        this.game = game;
    }


    public void tick(){
        x += velX;

        if (x <= -10)
            x = -10;

        if (x >= 640)
            x = 640;

        if(Physics.Collision(this, game.eb)){
            System.out.println("Collision");
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
