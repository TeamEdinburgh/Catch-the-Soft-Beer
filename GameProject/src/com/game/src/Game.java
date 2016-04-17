package com.game.src;


import EntityPack.EntityA;
import EntityPack.EntityB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable{

      public static final int WIDTH = 800;
      public static final int HEIGHT = 640;
      public static final int SCALE = 1;
      public final String TITLE = "Catch the beer";

      private boolean running = false;
      private Thread thread;

     private BufferedImage image = new BufferedImage(WIDTH ,HEIGHT , BufferedImage.TYPE_3BYTE_BGR);
     private BufferedImage spriteSheet = null;
     private BufferedImage background = null;

    private int beerCount = 10;
    private int beerCollected = 0;

    private Player p;
    private Bottles b;
    private Controller c;
    private Textures tex;

    public LinkedList<EntityA> ea;
    public LinkedList<EntityB> eb;

    public void init(){
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet = loader.loadImage("/Sprite.png");
            background = loader.loadImage("/back2.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        tex = new Textures(this);

        p = new Player(300,410, tex, this);
        b = new Bottles( 100, 100,tex);
        c = new Controller(this, tex);

        ea = c.getEntityA();
        eb = c.getEntityB();

        addKeyListener(new KeyInput(this));

        c.createBottles(beerCount);

    }
    private synchronized void start(){
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if(!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }


    public void run(){
        init();
        long lastTime = System.nanoTime();
        final  double amountOFTicks = 60.0;
        double ns = 1000000000 /amountOFTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + "Ticks ,FPs " +frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void tick(){

        p.tick();
        c.tick();
    }
    public void render(){
        BufferStrategy bs  = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g  = bs.getDrawGraphics();
            //////////////////////////////
        g.drawImage(image, 0 ,0,getWidth(),getHeight(),this);

        g.drawImage(background, -150,-40,null);

        p.render(g);
        c.render(g);
            //////////////////////////////

        g.dispose();
        bs.show();
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT){
            p.setVelX(8);
        }
        else if (key == KeyEvent.VK_LEFT){
            p.setVelX(-8);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT){
            p.setVelX(0);
        }
        else if (key == KeyEvent.VK_LEFT){
            p.setVelX(0);
        }

    }

    public static void main (String args []){
        Game game = new Game();

        game.setPreferredSize(new Dimension(WIDTH ,HEIGHT));
        game.setMaximumSize(new Dimension(WIDTH ,HEIGHT));
        game.setMinimumSize(new Dimension(WIDTH ,HEIGHT));


        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
    public BufferedImage getSpriteSheet(){
        return spriteSheet;

    }

    public int getBeerCount() {

        return beerCount;
    }

    public void setBeerCount(int beerCount) {

        this.beerCount = beerCount;
    }

    public int getBeerCollected() {

        return beerCollected;
    }

    public void setBeerCollected(int beerCollected) {
        this.beerCollected = beerCollected;
    }

}
