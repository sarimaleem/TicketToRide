import java.util.Collections;
import java.util.ArrayList;

public class TrainCardDeck {
    private ArrayList<TrainCard> deck;
    private ArrayList<TrainCard> faceUpCards;



    public TrainCardDeck() {
        deck = new ArrayList<>();
        String [] colors={"blue","green","black","orange","purple","red","white","yellow"};
        for(int i=0;i<colors.length;i++) {
            for (int j = 0; j < 12; j++) {
                TrainCard t = new TrainCard(colors[i]);
                deck.add(t);
            }
        }
        for (int i = 0; i < 14; i++) {
            TrainCard t = new TrainCard("wild");
            deck.add(t);
        }

        faceUpCards = new ArrayList<>();
        shuffle();

        for (int i = 0; i < 5; i++) {
            faceUpCards.add(deck.remove(0));
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void drawFaceUpCard(int index, Player player) {

        if (index == -1) {
            return;
        }

        if (index == 5) {
            //picks from the deck
            TrainCard toAdd = deck.remove(0);
            player.setTrainPoints(player.getTrainPoints() - 1);
            player.addTrainCard(toAdd);
            return;
        }

        String toAddColor = faceUpCards.get(index).getColor();

        if (toAddColor.equals("wild") && player.getTrainPoints() < 2) {
            return;
        } else if (toAddColor.equals("wild") && player.getTrainPoints() == 2){
            TrainCard toAdd = faceUpCards.remove(index);
            player.addTrainCard(toAdd);
            faceUpCards.add(index, deck.remove(0));
            player.setTrainPoints(0);
            solveWildCardProblem();

        } else {
            //not wild card
            TrainCard toAdd = faceUpCards.remove(index);
            player.addTrainCard(toAdd);
            faceUpCards.add(index, deck.remove(0));
            player.setTrainPoints(player.getTrainPoints() -1);
            solveWildCardProblem();
        }
    }

    public void solveWildCardProblem() {
        while (hasThreeWild()) {
            deck.addAll(faceUpCards);
            faceUpCards.clear();
            Collections.shuffle(deck);
            for (int i = 0; i < 5; i++) {
                faceUpCards.add(deck.remove(0));
            }
        }
    }

    public ArrayList<TrainCard> getFaceUpCards() {
        return faceUpCards;
    }

    public boolean hasThreeWild() {
        int cnt=0;
        for(int i=0;i<5;i++){
            if(faceUpCards.get(i).getColor().equals("wild"))
                cnt++;
        }
        if(cnt>=3)
            return true;
        return false;
    }

    public TrainCard drawFromDeck() {
        Collections.shuffle(deck);
        return deck.remove(0);
    }

}

