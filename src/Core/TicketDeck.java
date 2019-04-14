import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketDeck {
    private ArrayList<Ticket> deck;

    public TicketDeck() throws FileNotFoundException {
        deck = new ArrayList<Ticket>();
        Scanner cards = new Scanner(new File("Tickets.txt"));

        int total=cards.nextInt();
        String space=cards.nextLine();
        for(int x=0;x<total;x++){
            String tick=cards.nextLine();
            String[] str=tick.split("-");
            deck.add(new Ticket(str[1],str[2],Integer.parseInt(str[0])));
        }
        shuffle();
    }
    public void addTicket(Ticket ad){
        deck.add(ad);
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Ticket drawTicket(){
        return deck.remove(0);
    }
}
