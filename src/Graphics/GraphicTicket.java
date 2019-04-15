import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class GraphicTicket    {
    private Ticket ticket;
    private int x,y;

    public GraphicTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void drawTicket(Graphics2D g,int x,int y) {
        g.setStroke(new BasicStroke(3));
        g.setColor(new Color(240,234,214));
        g.fillRoundRect(x,y,225,150,10,10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x,y,225,150,10,10);
        Font t= new Font("Arial", Font.BOLD,30);
        g.setFont(t);
        g.drawString(ticket.getA()+"",x+5,y+30);
        g.drawString(ticket.getB()+"",x+5,y+145);
        g.drawString(ticket.getValue()+"",x+90,y+90);
    }
}

