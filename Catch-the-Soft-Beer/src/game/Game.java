package game;

import game.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private String title;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private Thread thread;
    private boolean isRunning;

    public Game(String name){
        this.title = name;
    }

    private void init(){
        this.display = new Display(title);
    }

    private void tick() {

    }

    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = this.bs.getDrawGraphics();

        //Begin Drawing
        g.drawImage(ImageLoader.loadImage("/textures/SoftUni-bg.jpg"), 0, 0, null);
        g.drawImage(ImageLoader.loadImage("/textures/softuniBeer.png"), 500, 50, null);
        g.drawImage(ImageLoader.loadImage("/textures/softuniBeer.png"), 300, 100, null);
        g.drawImage(ImageLoader.loadImage("/textures/softuniBeer.png"), 250, 150, null);
        g.drawImage(ImageLoader.loadImage("/textures/softuniBeer.png"), 400, 20, null);
        g.drawImage(ImageLoader.loadImage("/textures/softuniBeer.png"), 350, 200, null);
        g.drawImage(ImageLoader.loadImage("/textures/wizard.png"), 200, 420, null);

        g.setColor(Color.red);
        g.drawLine(150, 700 , 150, 0);

        g.setColor(Color.red);
        g.drawLine(550, 700 , 550, 50);

        g.setColor(Color.red);
        g.drawString("Score", 600, 25);

        char [] score = { 'S', 'c', 'o', 'r', 'e'};
        g.drawChars(score, 0, 5, 600, 50);

        Font f = new Font("Dialog", Font.BOLD, 12);
        g.setFont(f);
        g.drawString("Score", 600, 75);
        //End Drawing

        this.g.dispose();
        this.bs.show();
    }

    @Override
    public void run() {
        this.init();
        while (isRunning){
            this.tick();
            this.render();
        }
        this.stop();
    }
    public synchronized void start(){
        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }
    public synchronized void stop(){
        try {
            this.isRunning = false;
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
