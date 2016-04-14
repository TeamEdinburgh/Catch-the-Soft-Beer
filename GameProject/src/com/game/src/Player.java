package com.game.src;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private double x;
    private double y;

    private double velX = 0;

    private BufferedImage player;

    public Player(double x , double y, Game game){
        this.x = x;
        this.y = y;

        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());

        player = ss.grabImage(0,0, 200,241);
    }


    public void tick(){
        x += velX;

        if (x <= -10)
            x = -10;

        if (x >= 640)
            x = 640;

    }

    public void render(Graphics g){
        g.drawImage(player, (int)x, (int)y ,null);
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
