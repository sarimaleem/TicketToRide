import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
public class TicketDeck {
    private ArrayList<Ticket> deck;

    public TicketDeck(){
        deck = new ArrayList<Ticket>();

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
