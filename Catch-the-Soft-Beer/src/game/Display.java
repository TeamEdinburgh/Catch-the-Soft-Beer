package game;

import javax.swing.*;
import java.awt.*;


public class Display {
    private final int WIDTH = 700;
    private final int HEIGHT = 700;
    private String name;


    private JFrame frame;

    public Display(String name){
        init(name);
    }

    private void init(String name){
        this.name = name;
        this.frame = new JFrame(name);
        this.frame.setVisible(true);
        this.frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setFocusable(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
