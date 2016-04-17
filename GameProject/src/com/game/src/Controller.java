package com.game.src;

import EntityPack.EntityA;
import EntityPack.EntityB;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
    private LinkedList<EntityA> ea = new LinkedList<EntityA>();
    private LinkedList<EntityB> eb = new LinkedList<EntityB>();

    EntityA enta;
    EntityB entb;
    Random r = new Random();

    private Game game;
    Textures tex;

    public Controller( Textures tex, Game game){
        this.game = game;
        this.tex = tex;
    }

    public void createBottles(int beerCount){
        for (int i = 0; i < beerCount; i++) {
            addEntity(new Bottles(r.nextInt(640), -10, tex, this, game));
        }
    }

    public void tick(){
        //Entity A CLASS
        for (int i = 0; i < ea.size(); i++) {
            enta = ea .get(i);

            enta.tick();
        }

        //Entity B CLASS
        for (int i = 0; i < eb.size(); i++) {
            entb = eb .get(i);

            entb.tick();
        }

    }

    public void render(Graphics g){
        //Entity A CLASS
        for (int i = 0; i < ea.size(); i++) {
            enta = ea .get(i);

            enta.render(g);
        }
        //Entity B CLASS
        for (int i = 0; i < eb.size(); i++) {
            entb = eb .get(i);

            entb.render(g);
        }
    }

    public void addEntity (EntityA block){
        ea.add(block);
    }

    public void removeEntity (EntityA block){
        ea.add(block);
    }

    public void addEntity (EntityB block){
        eb.add(block);
    }

    public void removeEntity (EntityB block){
        eb.add(block);
    }

    public LinkedList<EntityA> getEntityA(){
        return ea;
    }
    public LinkedList<EntityB> getEntityB(){
        return eb;
    }

}
