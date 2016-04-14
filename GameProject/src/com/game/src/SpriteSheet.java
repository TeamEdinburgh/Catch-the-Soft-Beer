package com.game.src;

import java.awt.image.BufferedImage;


public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(BufferedImage image){

        this.image = image;
    }

    public BufferedImage grabImage(int col,int row,int wight,int height){
        //This part here needs to be fixed so we can find the image coordinates easier
        //May be we have to use Bogomil`s video
        //This part communicate with Texture.java
        BufferedImage img = image.getSubimage( col, row, wight, height);
        return img;
    }
}
