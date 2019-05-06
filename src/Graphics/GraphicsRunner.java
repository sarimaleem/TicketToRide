import java.io.*;
import java.awt.*;
import javax.swing.*;

public class GraphicsRunner extends JFrame{
    private static final int WIDTH = 1920;//1207;
    private static final int HEIGHT = 1080;//830;
    public static void main(String[]args) throws IOException{
        GraphicsRunner help=new GraphicsRunner();
    }

    public GraphicsRunner() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        Color C = new Color(110, 160, 148);
        setBackground(C);
        setResizable(false);
        add(new GraphicsBoard());
        setVisible(true);
    }
}