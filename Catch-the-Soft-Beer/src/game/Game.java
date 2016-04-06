package game;

import game.Display;

public class Game implements Runnable {
    private Display display;
    private Thread thread;
    private String name;
    private boolean isRunning;

    public Game(String name){

    }

    private void init(){
        this.display = new Display(name);
    }

    private void tick() {

    }

    private void render(){

    }

    @Override
    public void run() {
        while (isRunning){
            tick();
            render();
        }
    }
    public void start(){
        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }
    public void stop(){
        try {
            this.isRunning = false;
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
