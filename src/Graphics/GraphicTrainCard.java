import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class GraphicTrainCard extends JPanel implements MouseListener{
    private BufferedImage image;
    private int x,y;
    public GraphicTrainCard() {
        x=0;
        y=0;
        try {
            image = ImageIO.read(new File("Board.png"));
        }catch(IOException ex) {

        }
        addMouseListener(this);
        repaint();
    }
    public void paint(Graphics g) {
        Font myFont = new Font("Serif", Font.BOLD, 25);
        g.setFont(myFont);
        g.drawImage(image, 0, 0, getWidth(),getHeight() , this);
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
