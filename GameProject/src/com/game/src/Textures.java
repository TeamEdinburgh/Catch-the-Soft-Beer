package com.game.src;


import java.awt.image.BufferedImage;

public class Textures {
    public BufferedImage player, bottles;
    public BufferedImage[] nakov = new BufferedImage[4];
    private  SpriteSheet ss;

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }

    private void getTextures(){
        player = ss.grabImage( 0, 0, 126, 170);
        bottles = ss.grabImage(140, 130, 33, 50);
        nakov[0] = ss.grabImage(0, 178, 170, 125);
        nakov[1] = ss.grabImage(168, 178, 170, 125);
        nakov[2] = ss.grabImage(336, 178, 170, 125);
        nakov[3] = ss.grabImage(504, 178, 170, 125);

    }
}
