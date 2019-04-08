import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphicDrawTicket extends JPanel implements MouseListener {
    private TicketDeck deck;
    private int x;
    private int y;
    private String str;
    private boolean first,second,third,last,toPaint;
    Ticket one,two,three;

    public GraphicDrawTicket() throws IOException {
        first=true;second=true;third=true;last=true;toPaint=true;
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
        one=deck.drawTicket();
        two=deck.drawTicket();
        three=deck.drawTicket();
        repaint();
    }

    public void paint(Graphics g){
        Graphics2D g2d= (Graphics2D)g;
        g2d.setColor(Color.RED);
        g2d.fillRect(0,0,10000,10000);
        ArrayList<Ticket> e=drawTickets(g2d);
        if(last){
            toPaint=true;
        }else{
            toPaint=false;
        }
        g2d.setColor(Color.BLACK);
        g2d.drawRect(1000,600,200,200);
        g2d.drawRect(1000,100,200,200);
        g2d.drawRect(1200,100,200,200);
    }
    public ArrayList<Ticket> Check(){
        ArrayList<Ticket> ret = new ArrayList<Ticket>();
        if(last){
            return null;
        }else{
            if(first){
                ret.add(one);
            }
            if(second){
                ret.add(two);
            }
            if(third){
                ret.add(three);
            }
            if(!first){
                deck.addTicket(one);
            }
            if(!second){
                deck.addTicket(two);
            }
            if(!third){
                deck.addTicket(three);
            }
            one=deck.drawTicket();
            two=deck.drawTicket();
            three=deck.drawTicket();
            return ret;
        }
    }
    public void reset(){
        first=true;
        second=true;
        third=true;
        last=true;
    }
    public ArrayList<Ticket> drawTickets(Graphics2D g) {
        GraphicTicket f=new GraphicTicket(one);
        GraphicTicket s=new GraphicTicket(two);
        GraphicTicket t=new GraphicTicket(three);
        ArrayList<Ticket> ret = new ArrayList<Ticket>();


        if(str.equals("1")){
            first=false;
            if(!second&&!first||!third&&!first){
                last=false;
            }
            str="";
        }else if(str.equals("2")){
            second=false;
            if(!second&&!third||!second&&!first){
                last=false;
            }
            str="";
        }else if(str.equals("3")){
            third=false;
            if(!third&&!first||!third&&!second){
                last=false;
            }
            str="";
        }else if(str.equals("null")){
            last=false;
            str="";
        }
        if(first&&last){
            f.drawTicket(g,100,100);
        }else{
            f.drawTicket(g,-1000,0);
        }
        if(second&&last){
            s.drawTicket(g,400,100);
        }else{
            s.drawTicket(g,-400,0);
        }
        if(third&&last){
            t.drawTicket(g,700,100);
        }else{
            t.drawTicket(g,-700,0);
        }
        ArrayList<Ticket> c =Check();
        return c;
    }
    public void mouseClicked(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        if(x>=1000&&x<=1200&&y>=600&&y<=800&&!toPaint){
            System.out.println("Test1");
            toPaint=true;
            reset();
            repaint();
        }
        if(x>=100&&x<=325&&y>=100&&y<=250&&toPaint&&first){
            System.out.println("Test2");
            str="1";
            repaint();
        }
        if(x>=400&&x<=625&&y>=100&&y<=250&&toPaint&&second){
            System.out.println("Test3");
            str="2";
            repaint();
        }
        if(x>=700&&x<=925&&y>=100&&y<=250&&toPaint&&third){
            System.out.println("Test4");
            str="3";
            repaint();
        }
        if(x>=1000&&x<=1200&&y>=100&&y<=250&&toPaint){
            System.out.println("Test5");
            str="null";
            repaint();
        }
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
