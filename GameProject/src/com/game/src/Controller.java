package com.game.src;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
    private LinkedList<Entity> e = new LinkedList<Entity>();

    Entity ent;
    Random r = new Random();

    Game game;
    Textures tex;

    public Controller(Game game, Textures tex){
        this.game = game;
        this.tex = tex;
    }

    public void createBottles(int beerCount){
        for (int i = 0; i < beerCount; i++) {
            addEntitiy(new Bottles(r.nextInt(640), -10, tex));
        }
    }

    public void tick(){
        for (int i = 0; i < e.size(); i++) {
            ent = e .get(i);

            ent.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < e.size(); i++) {
            ent = e .get(i);

            ent.render(g);
        }
    }

    public void addEntitiy (Entity block){
        e.add(block);
    }

    public void removeEntity (Entity block){
        e.add(block);
    }

}
