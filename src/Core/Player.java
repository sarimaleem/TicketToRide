import java.util.ArrayList;

public class Player {

    private int numTrains;
    private int points;
    private String trainColor;
    private ArrayList<TrainCard> trainCards;
    private ArrayList<Ticket> tickets;
    private int trainPoints;

    public Player(String trainColor) {
        numTrains = 45;
        points = 0;
        this.trainColor = trainColor;
        trainCards = new ArrayList<TrainCard>();
        tickets = new ArrayList<>();
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

    public int getNumTrainCard (String color){
        int cnt = 0;
        for (int i = 0; i < trainCards.size(); i++) {
            if (trainCards.get(i).getColor().equals(color))
                cnt++;
        }
        return cnt;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }




}