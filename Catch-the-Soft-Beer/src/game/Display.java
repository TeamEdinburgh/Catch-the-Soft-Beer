package game;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.gray;
import static java.awt.Color.red;


public class Display {
    private final int WIDTH = 700;
    private final int HEIGHT = 700;
    private String name;

    private JFrame frame;
    private Canvas canvas;
    private Graphics g;

    public Display(String name){

        init(name);
    }

    public Canvas getCanvas() {
      return canvas;
    }

    private void init(String name){
        this.name = name;
        this.frame = new JFrame(name);
        this.frame.setVisible(true);
        this.frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setFocusable(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.canvas = new Canvas();
        this.canvas.setVisible(true);
        this.canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        this.frame.add(canvas);
        this.frame.pack();
    }
}
