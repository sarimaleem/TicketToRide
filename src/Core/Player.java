import java.util.ArrayList;

public class Player {


    //TODO finish player class, including taking traincards
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
}

//HI THIS IS A TEST COMMENT
