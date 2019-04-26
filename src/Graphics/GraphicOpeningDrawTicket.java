import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicOpeningDrawTicket extends JPanel implements MouseListener {
    private TicketDeck deck;
    private int x;
    private int y;
    private String str;
    ArrayList<Ticket> tickets;
    private boolean finish;
    public GraphicOpeningDrawTicket(GameState gameState){
        finish =true;
        tickets=new ArrayList<Ticket>(3);
        str="";
        x = y = 0;
        deck = gameState.getTicketDeck();
        deck.shuffle();
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        repaint();
    }
    public void paint(Graphics g){
        Graphics2D g2d= (Graphics2D)g;
        Font t= new Font("Arial", Font.BOLD,30);
        g2d.setFont(t);
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.LIGHT_GRAY);
        //g2d.fillRect(0,0,2000,1100);
        drawTickets(g2d);
        g2d.setColor(new Color(240,234,214));
        //g2d.fillRect(1700,900,200,100);
        if(finish){
            g2d.fillRect(1550,500,200,100);
        }
        g2d.setColor(Color.BLACK);
        //g2d.drawRect(1700,900,200,100);
        if(finish){
            g2d.drawRect(1550,500,200,100);
            g2d.drawRect(150,200,1600,400);
        }
        if(finish){
            g2d.drawString("Take",1560,540);
            g2d.drawString("Remaining",1560,580);
        }
        //g2d.drawString("Draw",1710,940);
        //g2d.drawString("Contracts",1710,980);
    }
    public ArrayList<Ticket> getContracts(){
        if(finish){
            return null;
        }
        return tickets;
    }
    public TicketDeck ReturnRemainingDeck(){
        return deck;
    }
    public void reset(){
        while(tickets.size()>0){
            tickets.remove(0);
        }
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        finish =true;
    }
    public void drawTickets(Graphics2D g) {
        if(str.equals("1")&&tickets.size()>3){
            deck.addTicket(tickets.remove(0));
            str="";
        }else if(str.equals("2")&&tickets.size()>3){
            deck.addTicket(tickets.remove(1));
            str="";
        }else if(str.equals("3")&&tickets.size()>3){
            deck.addTicket(tickets.remove(2));
            str="";
        }else if(str.equals("4")&&tickets.size()>3){
            deck.addTicket(tickets.remove(3));
            str="";
        }else if(str.equals("5")&&tickets.size()>4){
            deck.addTicket(tickets.remove(4));
            str="";
        }else if(str.equals("null")){
            finish =false;
            str="";
        }

        if(finish){
            g.setColor(Color.GRAY);
            g.fillRect(150,200,1600,400);
        }
        if(tickets.size()>0&& finish) {
            GraphicTicket f=new GraphicTicket(tickets.get(0));
            f.drawTicket(g,225,300);
        }
        if(tickets.size()>1&& finish) {
            GraphicTicket s=new GraphicTicket(tickets.get(1));
            s.drawTicket(g,525,300);
        }
        if(tickets.size()>2&& finish) {
            GraphicTicket t=new GraphicTicket(tickets.get(2));
            t.drawTicket(g,825,300);
        }
        if(tickets.size()>3&& finish) {
            GraphicTicket l=new GraphicTicket(tickets.get(3));
            l.drawTicket(g,1125,300);
        }
        if(tickets.size()>4&& finish) {
            GraphicTicket o=new GraphicTicket(tickets.get(4));
            o.drawTicket(g,1425,300);
        }
    }
    public void mouseReleased(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        if(x>=225&&x<=450&&y>=300&&y<=450&&tickets.size()>1&& finish){
            str="1";
            repaint();
        }
        if(x>=525&&x<=750&&y>=300&&y<=450&&tickets.size()>1&& finish){
            str="2";
            repaint();
        }
        if(x>=825&&x<=1050&&y>=300&&y<=450&&tickets.size()>2&& finish){
            str="3";
            repaint();
        }
        if(x>=1125&&x<=1350&&y>=300&&y<=450&&tickets.size()>3&& finish){

            str="4";
            repaint();
        }if(x>=1425&&x<=1650&&y>=300&&y<=450&&tickets.size()>4&& finish){
            str="5";
            repaint();
        }
        if(x>=1550&&x<=1750&&y>=500&&y<=600&& finish){
            str="null";
            repaint();
        }
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}
