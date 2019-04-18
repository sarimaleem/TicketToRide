import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainCardDeck {
    private ArrayList<TrainCard> deck;

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
        shuffle();
    }
    public void addCard(TrainCard t){
        deck.add(t);
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public TrainCard drawCard(){
        return deck.remove(0);
    }
}

