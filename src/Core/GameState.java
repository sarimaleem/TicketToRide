import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameState {

    private ArrayList<Player> players;
    private Network network;
    int currentPlayer;
    TicketDeck ticketDeck;
    TrainCardDeck trainCardDeck;
    boolean lastTurn;
    int turnsLeft;
    boolean finished;
    Player longestPathPlayer = null;
    Player globeTrotter = null;


    public GameState() throws FileNotFoundException {
        players = new ArrayList<>();
        players.add(new Player("red"));
        players.add(new Player("blue"));
        players.add(new Player("green"));
        players.add(new Player("yellow"));
        currentPlayer = 0;

        network = new Network();
        ticketDeck = new TicketDeck();
        trainCardDeck = new TrainCardDeck();

        for (Player p : getPlayers()) {
            for (int i = 0; i < 4; i++) {
                p.addTrainCard(trainCardDeck.drawFromDeck());
            }
        }


//        for (Player p : getPlayers()) {
//            for (int i = 0; i < 45; i++) {
//                p.addTrainCard(new TrainCard("wild"));
//            }
//        }


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

    public void setTicketDeck(TicketDeck a){
        ticketDeck=a;
    }

    public TicketDeck getTicketDeck() {
        return ticketDeck;
    }

    public void clearPotentialRoutes() {
        getCurrentPlayer().clearPotentialRoutes();
    }


    public void nextTurn() {
        getCurrentPlayer().setTrainPoints(2);


        ArrayList<Ticket> tickets = getCurrentPlayer().getTickets();

        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);

            if (getNetwork().ticketFinished(t.getA(), t.getB(), getCurrentPlayer())) {
                t.setFinished();
            }

            getNetwork().resetMarked();
        }
        System.out.println();


        if (lastTurn) {
            turnsLeft--;
            if (turnsLeft == 0) {
                finished = true;
                for (Player player : players) {
                    player.calcTotalPoints();
                    Player p = network.longestPath(players);
                    p.setPoints(p.getPoints() + 20);
                    longestPathPlayer = p;
                }
            }
        } else {
            checkLastTurn();
        }

        currentPlayer = (currentPlayer + 1)%players.size();
    }

    public boolean gameFinished() {
        return finished;
    }

    public void checkLastTurn() {
        for (Player player : players) {
            if (player.getNumTrains() <= 2) {
                lastTurn = true;
                turnsLeft = 4;
            }
        }
    }

    public void globeTrotter() {
        
    }

}
