package com.game.src;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
    private LinkedList<Bottles> b = new LinkedList<Bottles>();

    Random r = new Random();

    Bottles TempBottles;
    Game game;
    Textures tex;

    public Controller(Game game, Textures tex){
        this.game = game;
        this.tex = tex;

            addBottles(new Bottles( r.nextInt(Game.WIDTH * Game.SCALE), 0, tex));

    }

    public void tick(){
        for (int i = 0; i < b.size(); i++) {
            TempBottles = b.get(i);

            if (TempBottles.getY() > 640) {
                removeBottles(TempBottles);
            }
            
            TempBottles.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < b.size(); i++) {
            TempBottles = b.get(i);
            TempBottles.render(g);
        }
    }

    public void addBottles(Bottles block){
        b.add(block);
    }

    public void removeBottles(Bottles block){
        b.remove(block);
    }
}
