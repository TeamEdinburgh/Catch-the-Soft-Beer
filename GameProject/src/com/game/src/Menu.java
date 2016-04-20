package com.game.src;

import java.awt.*;

public class Menu {
    Game game;

    public Rectangle playButton = new Rectangle(350, 200, 100, 50);
    public Rectangle helpButton = new Rectangle(350, 300, 100, 50);
    public Rectangle quitButton = new Rectangle(350, 400, 100, 50);
    public Rectangle playAgainButton = new Rectangle(300, 390, 200, 50);

    public Menu(Game game){
        this.game = game;
    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if(game.State == Game.STATE.MENU) {
            Font font = new Font("arial", Font.BOLD, 50);
            g.setFont(font);
            g.setColor(Color.orange);
            g.drawString("MENU", 330, 100);

            Font font1 = new Font("arial", Font.BOLD, 30);
            g.setFont(font1);

            g.setColor(Color.blue);
            g.fillRect(350, 200, 100, 50);
            g.setColor(Color.orange);
            g.drawString("Play", playButton.x + 20, playButton.y + 30);
            g2d.draw(playButton);

            g.setColor(Color.blue);
            g.fillRect(350, 300, 100, 50);
            g.setColor(Color.orange);
            g.drawString("Help", helpButton.x + 20, helpButton.y + 30);
            g2d.draw(helpButton);

            g.setColor(Color.blue);
            g.fillRect(350, 400, 100, 50);
            g.setColor(Color.orange);
            g.drawString("Quit", quitButton.x + 20, quitButton.y + 30);
            g2d.draw(quitButton);

        }else if(game.State == Game.STATE.END){
            Font font = new Font("arial", Font.BOLD, 50);
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 250, 100);

            Font font1 = new Font("arial", Font.BOLD, 30);
            g.setFont(font1);
            g.drawString("You Dropped too many beers, but you collected: "+ game.getBeers(), 50, 200);

            g.setColor(Color.blue);
            g.fillRect(300, 390, 200, 50);
            g.setColor(Color.RED);
            g.drawString("Play Again", playAgainButton.x + 20, playAgainButton.y + 30);
            g2d.draw(playAgainButton);
        }

    }
}
