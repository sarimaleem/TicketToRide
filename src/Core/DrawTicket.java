import java.io.IOException;
import java.io.*;
import java.util.Scanner;
public class DrawTicket {
    private TicketDeck deck;
    public DrawTicket() throws IOException {
        deck=new TicketDeck();
        Scanner cards = new Scanner(new File("Tickets.txt"));
        int total=cards.nextInt();
        for(int x=0;x<total;x++){
            String tick=cards.nextLine();
        }
    }
}
