package game;

import game.Display;

public class Game {
    private Display display;
    public Game(String name){
        this.display = new Display(name);
    }
}
