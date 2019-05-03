import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class GraphicTicket extends JPanel {
    private Ticket ticket;
    private int x,y;
    private BufferedImage check;
    public GraphicTicket() {
        x=0;
        y=0;
        ticket=null;
        try {
            check = ImageIO.read(new File("Check.png"));
        }catch(IOException ex) {

        }
    }
    public GraphicTicket(Ticket z) {
        x=0;
        y=0;
        ticket=z;
        try {
            check = ImageIO.read(new File("Check.png"));
        }catch(IOException ex) {

        }
    }
    public GraphicTicket(String a,String b, int val) {
        x=0;
        y=0;
        ticket=new Ticket(a,b,val);
        try {
            check = ImageIO.read(new File("Check.png"));
        }catch(IOException ex) {

        }
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawTicket(graphics2D,x,y);
        repaint();
    }

    public void drawTicket(Graphics2D g,int x,int y) {
        g.setStroke(new BasicStroke(3));
        g.setColor(new Color(240, 234, 214));
        g.fillRoundRect(x,y,225,150,10,10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x,y,225,150,10,10);
        Font t= new Font("Arial", Font.BOLD,30);
        g.setFont(t);
        g.drawString(ticket.getA()+"",x+5,y+30);
        g.drawString(ticket.getB()+"",x+5,y+145);
        g.drawString(ticket.getValue()+"",x+90,y+90);
        if(ticket.isFinished()){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
            g.drawImage(check,x,y,225,150,this);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        }
    }
}