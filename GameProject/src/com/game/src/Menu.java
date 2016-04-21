package com.game.src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu {
    Game game;

    public Rectangle playButton = new Rectangle(350, 200, 100, 50);
    public Rectangle quitButton = new Rectangle(350, 400, 100, 50);

    public Menu(Game game) {
        this.game = game;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage pic = null;
        BufferedImage pic2 = null;

        if (game.State == Game.STATE.MENU) {
            BufferedImageLoader loader = new BufferedImageLoader();
            try {
                pic = loader.loadImage("/start.png");
                pic2 = loader.loadImage("/quit.png");
            }catch (IOException e){
                e.printStackTrace();
            }

           // Font font = new Font("arial", Font.BOLD, 50);
           // g.setFont(font);
           // g.setColor(Color.orange);
            // g.drawString("MENU", 330, 100);

            Font font1 = new Font("arial", Font.BOLD, 30);
            g.setFont(font1);

            g.drawImage(pic , 355,200,null);
            g.drawImage(pic2 , 360,380,null);

    }

}}