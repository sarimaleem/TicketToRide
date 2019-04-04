import java.util.ArrayList;

public class Gamestate {

    ArrayList<Player> players;
    Network n;
    int currentPlayer;



    public Gamestate() {
        players = new ArrayList<>();
        players.add(new Player("red"));
        players.add(new Player("blue"));
        players.add(new Player("green"));
        players.add(new Player("yellow"));

        currentPlayer = 0;

    }


    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }








}
