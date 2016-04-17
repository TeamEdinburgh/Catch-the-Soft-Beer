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
        player = ss.grabImage( 0, 0, 200, 222);
        bottles = ss.grabImage(200, 163, 40, 59);
    }
}
