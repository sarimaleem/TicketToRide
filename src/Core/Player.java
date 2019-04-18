import java.util.ArrayList;

public class Player {

    private int numTrains;
    private int points;
    private String trainColor;
    private ArrayList<TrainCard> trainCards;
    private ArrayList<Ticket> tickets;
    private int trainPoints;
    private ArrayList<PotentialRoute> potentialRoutes;


    public Player(String trainColor) {
        numTrains = 45;
        points = 0;
        this.trainColor = trainColor;
        trainCards = new ArrayList<TrainCard>();
        tickets = new ArrayList<>();
        potentialRoutes = new ArrayList<>();


    }

    public String getTrainColor() {
        return trainColor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addTrainCard(TrainCard trainCard) {
        trainCards.add(trainCard);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public int getNumTrainCard(String color) {
        int cnt = 0;
        for (int i = 0; i < trainCards.size(); i++) {
            if (trainCards.get(i).getColor().equals(color))
                cnt++;
        }
        return cnt;
    }

    public void removeTrainCards(String color, int n) {
        while (n > -1) {
            for (TrainCard trainCard : trainCards) {
                if (trainCard.getColor().equals(color)) {
                    trainCards.remove(trainCard);
                    n--;
                }
            }
        }
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public boolean isValidCardCombination(String color, int length) {
        int totalCards = getNumTrainCard(color) + getNumTrainCard("wild");
        if (totalCards >= length)
            return true;
        return false;
    }

    public void makePotentialRoutes(Route r) {
        potentialRoutes.clear();
        String[] colors = new String[]{"blue", "green", "black", "orange", "purple", "red", "white", "yellow"};
        for (String color : colors) {
            if (isValidCardCombination(color, r.getLength())) {
                potentialRoutes.add(new PotentialRoute(color, this, r));
            }
        }
    }

    public void clearPotentialRoutes() {
        potentialRoutes.clear();
    }

    public ArrayList<PotentialRoute> getPotentialRoutes() {
        return potentialRoutes;
    }


}