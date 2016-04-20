package com.game.src;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //public Rectangle playButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
        // public Rectangle helpButton = new Rectangle(Game.WIDTH / 2 + 120, 250, 100, 50);
        // public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 350, 100, 50);
        //public Rectangle playAgainButton = new Rectangle(300, 390, 200, 50);

        //Play Button
        if(mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220){
            if(my >= 150 && my <= 200){
                //pressed Play button
                Game.State = Game.STATE.GAME;
            }
        }

        //Play Again Button
        if(mx >= 300 && mx <= 500){
            if(my >= 390 && my <= 440){
                //pressed Play button
                Game.State = Game.STATE.GAME;
            }
        }


        //Quit Button
        if(mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220){
            if(my >= 350 && my <= 400){
                //pressed Quit button
                System.exit(1);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}