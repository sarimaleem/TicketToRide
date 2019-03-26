import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicTicket extends JPanel implements MouseListener {
    private Ticket ticket;
    public GraphicTicket() {
        ticket=null;
    }
    public GraphicTicket(Ticket x) {
        ticket=x;
    }
    public GraphicTicket(City a,City b, int val) {
        ticket=new Ticket(a,b,val);
    }
    public static void main(String[] args) {
        JFrame window = new JFrame("GraphicTicket"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        GraphicTicket board = new GraphicTicket();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.addMouseListener(board);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawTicket(graphics2D,1237,389);
        repaint();
    }

    public void drawTicket(Graphics2D g,int x,int y) {
        g.setStroke(new BasicStroke(3));
        g.setColor(new Color(240,234,214));
        g.fillRoundRect(x,y,225,150,10,10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x,y,225,150,10,10);
        Font t= new Font("Arial", Font.BOLD,30);
        g.setFont(t);
        g.drawString(ticket.getA().getName()+"",x+5,y+30);
        g.drawString(ticket.getB().getName()+"",x+5,y+145);
        g.drawString(ticket.getValue()+"",x+90,y+90);
    }
    public void mouseClicked(MouseEvent e) {


    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}

