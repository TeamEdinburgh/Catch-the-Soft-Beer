package game;

import game.Display;

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
        }
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
