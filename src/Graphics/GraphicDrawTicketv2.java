import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphicDrawTicketv2 extends JPanel implements MouseListener {

    private TicketDeck deck;
    private int x;
    private int y;
    private String str;
    ArrayList<Ticket> tickets;
    private boolean fin;

    public GraphicDrawTicketv2() throws IOException {
        fin=true;
        tickets=new ArrayList<Ticket>(3);
        str="";
        x=0;
        y=0;
        deck=new TicketDeck();
        Scanner cards = new Scanner(new File("Tickets.txt"));
        int total=cards.nextInt();
        String space=cards.nextLine();
        for(int x=0;x<total;x++){
            String tick=cards.nextLine();
            String[] str=tick.split("-");
            deck.addTicket(new Ticket(str[1],str[2],Integer.parseInt(str[0])));
        }
        deck.shuffle();
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
        g2d.fillRect(0,0,2000,1100);
        drawTickets(g2d);
        g2d.setColor(new Color(240,234,214));
        g2d.fillRect(1700,900,200,100);
        if(fin){
            g2d.fillRect(1250,500,200,100);
        }
        g2d.setColor(Color.BLACK);
        g2d.drawRect(1700,900,200,100);
        if(fin){
            g2d.drawRect(1250,500,200,100);
            g2d.drawRect(450,200,1000,400);
        }
        if(fin){
            g2d.drawString("Add",1260,540);
            g2d.drawString("Remaining",1260,580);
        }
        g2d.drawString("Draw",1710,940);
        g2d.drawString("Contracts",1710,980);
    }
    public void reset(){
        while(tickets.size()>0){
            tickets.remove(0);
        }
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        tickets.add(deck.drawTicket());
        fin=true;
    }
    public ArrayList<Ticket> getCards(){
        return tickets;
    }
    public void drawTickets(Graphics2D g) {
        if(str.equals("1")&&tickets.size()>1){
            deck.addTicket(tickets.remove(0));
            str="";
        }else if(str.equals("2")){
            deck.addTicket(tickets.remove(1));
            str="";
        }else if(str.equals("3")&&tickets.size()==3){
            deck.addTicket(tickets.remove(2));
            str="";
        }else if(str.equals("null")){
            fin=false;
            str="";
        }
        if(tickets.size()==1){
            fin=false;
        }
        if(fin){
            g.setColor(Color.GRAY);
            g.fillRect(450,200,1000,400);
        }
        if(tickets.size()>0&&fin) {
            GraphicTicket f=new GraphicTicket(tickets.get(0));
            f.drawTicket(g,525,300);
        }
        if(tickets.size()>1&&fin) {
            GraphicTicket s=new GraphicTicket(tickets.get(1));
            s.drawTicket(g,825,300);
        }
        if(tickets.size()>2&&fin) {
            GraphicTicket t=new GraphicTicket(tickets.get(2));
            t.drawTicket(g,1125,300);
        }
    }
    public void mouseReleased(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        if(x>=1700&&x<=1900&&y>=900&&y<=1000&&!fin){
            reset();
            repaint();
        }
        if(x>=525&&x<=750&&y>=300&&y<=450&&tickets.size()>1&&fin){
            str="1";
            repaint();
        }
        if(x>=825&&x<=1050&&y>=300&&y<=450&&tickets.size()>1&&fin){
            str="2";
            repaint();
        }
        if(x>=1125&&x<=1350&&y>=300&&y<=450&&tickets.size()==3&&fin){

            str="3";
            repaint();
        }
        if(x>=1250&&x<=1450&&y>=500&&y<=600&&tickets.size()>1&&fin){

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
