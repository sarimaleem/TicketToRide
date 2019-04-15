import java.awt.*;

public class GraphicTicket    {
    private Ticket ticket;

    public GraphicTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void drawTicket(Graphics2D graphics2D,int x,int y) {
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(new Color(240,234,214));
        graphics2D.fillRoundRect(x,y,225,150,10,10);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRoundRect(x,y,225,150,10,10);
        Font t= new Font("Arial", Font.BOLD,30);
        graphics2D.setFont(t);
        graphics2D.drawString(ticket.getA()+"",x+5,y+30);
        graphics2D.drawString(ticket.getB()+"",x+5,y+145);
        graphics2D.drawString(ticket.getValue()+"",x+90,y+90);
    }
}

