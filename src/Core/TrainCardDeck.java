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
    public void addCard(TrainCard t){
        deck.add(t);
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public TrainCard drawCard(int index){
        TrainCard toRemove = deck.remove(index);
        faceUpCards.add(deck.remove(0));
        return toRemove;
    }
    public TrainCard drawFaceUpCard(int index){
        TrainCard toRemove = faceUpCards.remove(index);
        faceUpCards.add(this.drawCard(0));
        return toRemove;
    }

    public ArrayList<TrainCard> getFaceUpCards() {
        return faceUpCards;
    }

}

