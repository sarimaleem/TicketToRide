import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class DrawTicket{
    private TicketDeck deck;
    private int x;
    private int y;
    public DrawTicket() throws IOException {
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
    }
    public ArrayList<Ticket> drawTickets() throws IOException{
        Ticket one=deck.drawTicket();
        Ticket two=deck.drawTicket();
        Ticket three=deck.drawTicket();
        boolean first=true,second=true,third=true,last=true;
        Scanner read= new Scanner(System.in);
        ArrayList<Ticket> ret = new ArrayList<Ticket>();
        while(last){
            System.out.println("1: "+one);
            System.out.println("2: "+two);
            System.out.println("3: "+three);
            System.out.println("Which Card to remove:");
            String str =read.nextLine();
            if(str.equals("1")){
                first=false;
                if(!second||!third){
                    last=false;
                }
            }else if(str.equals("2")){
                second=false;
                if(!first||!third){
                    last=false;
                }
            }else if(str.equals("3")){
                third=false;
                if(!second||!first){
                    last=false;
                }
            }else if(str.equals("null")){
                last=false;
            }
        }
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
        return ret;
    }
}
