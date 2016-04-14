package com.game.src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bottles {
    private double x;
    private double y;
    private Textures tex;


    public Bottles (double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    public void tick(){
        y += 5;
    }

    public void render(Graphics g){
        g.drawImage(tex.bottles, (int) x, (int) y, null);
    }

    public double getY(){
        return y;
    }
}
