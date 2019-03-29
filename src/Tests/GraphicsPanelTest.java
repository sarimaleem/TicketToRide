package Tests;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GraphicsPanelTest extends JPanel implements MouseListener{
    private BufferedImage map;
    private ArrayList<BufferedImage> cards;

    private int x,y;
    public GraphicsPanelTest() {
        x=0;
        y=0;
        cards = new ArrayList<>();
        try {
            map = ImageIO.read(new File("board.jpg"));
            cards.add(ImageIO.read(new File("black.png")));
            cards.add(ImageIO.read(new File("white.png")));
            cards.add(ImageIO.read(new File("blue.png")));
            cards.add(ImageIO.read(new File("green.png")));
            cards.add(ImageIO.read(new File("orange.png")));
            cards.add(ImageIO.read(new File("purple.png")));
            cards.add(ImageIO.read(new File("wild.png")));
            cards.add(ImageIO.read(new File("yellow.png")));
            cards.add(ImageIO.read(new File("red.png")));

        }catch(IOException ex) {

        }
        addMouseListener(this);
        repaint();
    }
    public void paint(Graphics g) {
        Font myFont = new Font("Serif", Font.BOLD, 25);
        g.setFont(myFont);
        g.drawImage(map, 0, 100, getWidth() - 500, getHeight() - 300, this);
        g.setColor(new Color(100, 50, 50));
        g.setFont(new Font("serif", Font.BOLD, 60));
        g.drawString("Ticket To Ride", 800, 70);
        for(int i = 0; i < cards.size(); i++)
        {
            g.drawImage(cards.get(i), 200, getHeight()-200, 100, 200, this);
        }
        g.drawString(x+"", 500, 500);
        g.drawString(y+"", 700, 500);

    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
        x=e.getX();
        y=e.getY();
        repaint();
    }

}