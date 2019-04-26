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


        currentPlayer = 0;

        network = new Network();
        ticketDeck = new TicketDeck();

        for (Player p : getPlayers()) {
            for (int i = 0; i < 10; i++) {
                p.addTrainCard(new TrainCard("purple"));
            }
        }

        for (Player p : getPlayers()) {
            for (int i = 0; i < 5; i++) {
                p.addTrainCard(new TrainCard("red"));
                p.addTrainCard(new TrainCard("wild"));
            }
        }


        network = new Network();
        ticketDeck = new TicketDeck();

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

    public void setTicketDeck(TicketDeck a){
        ticketDeck=a;
    }

    public TicketDeck getTicketDeck() {
        return ticketDeck;
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer + 1)%players.size();
    }

    public void clearPotentialRoutes() {
        getCurrentPlayer().clearPotentialRoutes();
    }

}
