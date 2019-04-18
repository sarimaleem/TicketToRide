import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameState {

    private ArrayList<Player> players;
    private Network network;
    int currentPlayer;
    TicketDeck ticketDeck;
    TrainCardDeck trainCardDeck;

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
        trainCardDeck=new TrainCardDeck();






    }


    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public TrainCardDeck getTrainCardDeck() {
        return trainCardDeck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Network getNetwork() {
        return network;
    }

}
