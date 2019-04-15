import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameState {

    private ArrayList<Player> players;
    private Network network;
    int currentPlayer;
    TicketDeck ticketDeck;

    public GameState() throws FileNotFoundException {

        players = new ArrayList<>();
        players.add(new Player("red"));
        players.add(new Player("blue"));
        players.add(new Player("green"));
        players.add(new Player("yellow"));
        currentPlayer = 0;


        network = new Network();
        ticketDeck = new TicketDeck();

        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
        getCurrentPlayer().addTicket(ticketDeck.drawTicket());
    }


    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Network getNetwork() {
        return network;
    }
}
