import javax.swing.*;


public class Display {
    private String name;
    private int width;
    private int height;

    private JFrame frame;

    public Display(String name){
        init(name);
    }

    private void init(String name){
        this.frame = new JFrame(name);
    }
}
