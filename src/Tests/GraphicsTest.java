
import java.util.*;
import static java.lang.System.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsTest extends JFrame{
    private static final int WIDTH = 1920;//1207;
    private static final int HEIGHT = 1080;//830;
    public static void main(String[]args) throws IOException{



        GraphicsTest help=new GraphicsTest();







    }
    public GraphicsTest() throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        Color C= new Color(110, 160, 148);
        setBackground(C);
        setResizable(false);
        add(new GraphicsPanelTest());
        setVisible(true);
    }
}