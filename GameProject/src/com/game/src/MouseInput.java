package com.game.src;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import static com.game.src.Game.State;

public class MouseInput implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e ) {
        int mx = e.getX();
        int my = e.getY();
        Game game;
        //public Rectangle playButton = new Rectangle(350, 200, 100, 50);
        //public Rectangle helpButton = new Rectangle(350, 300, 100, 50);
        //public Rectangle quitButton = new Rectangle(350 , 400, 100, 50);
        //public Rectangle playAgainButton = new Rectangle(300, 390, 200, 50);


        if (State == Game.STATE.MENU) {
            //Play Button
            if (mx >= 350 && mx <= 450) {
                if (my >= 200 && my <= 250) {
                    //pressed Play button
                    State = Game.STATE.GAME;
                }
            }
            //Quit Button
            if (mx >= 350 && mx <= 450) {
                if (my >= 400 && my <= 450) {
                    //pressed Quit button
                    System.exit(1);
                }
            }
        }
        if (State == Game.STATE.END){
            if (mx >= 345 && mx <= 451) {
                if (my >= 400 && my <= 450) {
                    //pressed Play button
                    State = Game.STATE.GAME;

                }
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