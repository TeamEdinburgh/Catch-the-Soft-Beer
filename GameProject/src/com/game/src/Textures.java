package com.game.src;


import java.awt.image.BufferedImage;

public class Textures {
    public BufferedImage player, bottles, nakov;
    private  SpriteSheet ss;

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }

    private void getTextures(){
        player = ss.grabImage( 0, 0, 126, 170);
        bottles = ss.grabImage(140, 130, 33, 50);
        nakov = ss.grabImage(0, 178, 170, 125);
    }
}
