package com.game.src;


import java.awt.image.BufferedImage;

public class Textures {
    public BufferedImage player, bottles;
    private  SpriteSheet ss;

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }

    private void getTextures(){
        //This part here needs to be fixed so we can find the image coordinates easier
        //May be we have to use Bogomil`s video
        //This part communicate with SpriteSheet.java
        player = ss.grabImage( 0, 0, 200, 222);
        bottles = ss.grabImage(200, 163, 40, 59);
    }
}
