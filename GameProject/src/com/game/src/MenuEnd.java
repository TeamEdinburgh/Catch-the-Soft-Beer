package com.game.src;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuEnd {
    Game game;


    public Rectangle playAgainButton = new Rectangle(350, 400, 100, 50);
    private BufferedImage pic = null;

    public MenuEnd(Game game){
        this.game = game;
    }
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("consolas", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("GAME OVER", 250, 100);

        Font font1 = new Font("consolas", Font.BOLD, 27);
        g.setFont(font1);
        g.drawString("You Dropped too many beers, but you collected: " + game.getBeers(), 40, 200);

        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            pic = loader.loadImage("/playagain.png.png");
        }catch (IOException e){
            e.printStackTrace();
        }


        g.drawImage(pic , 345,400,null);
    }
}
