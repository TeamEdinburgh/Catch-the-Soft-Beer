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


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 640;
    public static final int SCALE = 1;
    public final String TITLE = "Catch the beer";
    public int level = 1;

    private boolean running = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;
    private BufferedImage beerPic = null;

    private int beers = 0;
    private int beerCount = 2;
    private int beerCollected = 0;


    private Player p;
    private Nakov n;
    private Controller c;
    private Textures tex;
    private Menu menu;
    private MenuEnd menuEnd;


    public LinkedList<EntityA> ea;
    public LinkedList<EntityB> eb;

    public static int COLLECTED = 0;
    public static int DROPPED = 400;

    //enum: a special data type that enables for a variable to be a set of predefined constants
    public static enum STATE {
        MENU,
        GAME,
        END
    }

    ;

    public static STATE State = STATE.MENU;

    public void init() {
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet = loader.loadImage("/Sprite1.png");
            background = loader.loadImage("/back2.png");
            beerPic = loader.loadImage("/beer.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        tex = new Textures(this);


        c = new Controller(tex, this);
        p = new Player(300, 470, tex, this, c);
        n = new Nakov(650, 200, tex, this, c);
        menu = new Menu(this);
        menuEnd = new MenuEnd(this);

        ea = c.getEntityA();
        eb = c.getEntityB();

        this.addKeyListener(new KeyInput(this));
        this.addMouseListener(new MouseInput());

        c.createBottles(beerCount);

    }

    private synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }


    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOFTicks = 60.0;
        double ns = 1000000000 / amountOFTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            if (State == STATE.END){

            }
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + "Ticks ,FPs " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        if (State == STATE.GAME) {
            p.tick();
            n.tick();
            c.tick();
            if (DROPPED <= 0) {
                COLLECTED = 0;
                DROPPED = 300;
                State = STATE.END;
                level = 1;
            }
            if (COLLECTED >= 200) {
                COLLECTED = 0;
                level++;
            }
        }

        if (beerCollected >= beerCount) {
            beerCount += 2;
            beerCollected = 0;
            c.createBottles(beerCount);
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //////////////DRAWING////////////////
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(background, -150, -40, null);
        if (State == STATE.GAME) {
            n.render(g);
            p.render(g);
            c.render(g);

            //Collected beers bar
            g.setColor(Color.WHITE);
            g.fillRect(5, 5, 200, 30);

            g.setColor(Color.green);
            g.fillRect(5, 5, COLLECTED, 30);

            g.setColor(Color.white);
            g.drawRect(5, 5, 200, 30);

            Font font = new Font("arial", Font.BOLD, 14);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Score :" + COLLECTED +  "/200" , 210, 20);

            if (DROPPED == 400) {
                g.drawImage(beerPic, 730, 140, null);
                g.drawImage(beerPic, 700, 140, null);
                g.drawImage(beerPic, 670, 140, null);
            } else if (DROPPED == 300) {
                g.drawImage(beerPic, 730, 140, null);
                g.drawImage(beerPic, 700, 140, null);
            } else if (DROPPED == 200) {
                g.drawImage(beerPic, 700, 140, null);

            }


            font = new Font("arial", Font.BOLD, 50);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString(" Level: " + level, 300, 50);

        } else if (State == STATE.MENU) {
            menu.render(g);
        } else if (State == STATE.END) {
            menuEnd.render(g);
        }
        //////////////////////////////

        g.dispose();
        bs.show();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (State == STATE.GAME) {
            if (key == KeyEvent.VK_RIGHT) {
                p.setVelX(15);
            } else if (key == KeyEvent.VK_LEFT) {
                p.setVelX(-15);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            p.setVelX(0);
        } else if (key == KeyEvent.VK_LEFT) {
            p.setVelX(0);
        }

    }

    public static void main(String args[]) {
        Game game = new Game();

        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        game.setMinimumSize(new Dimension(WIDTH, HEIGHT));


        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public int getBeers() {
        return beers;
    }

    public void setBeers(int beers) {
            this.beers = beers;
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
