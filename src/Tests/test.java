import java.util.*;
import static java.lang.System.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JFrame{
    private static final int WIDTH = 1920;//1207;
    private static final int HEIGHT = 1080;//830;
    public static void main(String[]args) throws IOException{



        test help=new test();
    }
    public test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        Color C= new Color(160,0,0);
        setBackground(C);
        setResizable(false);
        add(new test());
        setVisible(true);
    }
}