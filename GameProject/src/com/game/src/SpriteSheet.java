package com.game.src;

import java.awt.image.BufferedImage;


public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(BufferedImage image){
        this.image = image;
    }

    public BufferedImage grabImage(int col,int row,int wight,int height){
        BufferedImage img = image.getSubimage( col, row, wight, height);
        return img;
    }
}
