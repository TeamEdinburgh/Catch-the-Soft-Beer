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

        //public Rectangle playButton = new Rectangle(350, 200, 100, 50);
        // public Rectangle helpButton = new Rectangle(350, 300, 100, 50);
        // public Rectangle quitButton = new Rectangle(350 , 400, 100, 50);
        //public Rectangle playAgainButton = new Rectangle(300, 390, 200, 50);

        //Play Button
        if(mx >= 350  && mx <= 450){
            if(my >= 200 && my <= 250){
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
        if(mx >= 350  && mx <= 450 ){
            if(my >= 400 && my <= 450){
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