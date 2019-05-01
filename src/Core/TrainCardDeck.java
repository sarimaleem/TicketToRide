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
        return toRemove;
    }



    public void drawFaceUpCard(int index, Player player) {

        if (index == -1) {
            return;
        }

        if (index == 6) {
            //picks from the deck
            TrainCard toAdd = deck.remove(0);
            player.setTrainPoints(player.getPoints() - 1);
            player.addTrainCard(toAdd);
            return;
        }

        String toAddColor = faceUpCards.get(index).getColor();

        if (toAddColor.equals("wild") && player.getTrainPoints() < 2) {
            return;
        } else {
            TrainCard toAdd = faceUpCards.remove(index);
            player.addTrainCard(toAdd);
            faceUpCards.add(index, deck.remove(0));
            return;
        }





//        TrainCard toRemove = faceUpCards.remove(index);
//        faceUpCards.add(index,deck.remove(0));
//        return toRemove;


//        if(gameState.getCurrentPlayer().getTrainPoints()>0) {
//            if (graphicCards.contains(x, y)) {
//                if (graphicCards.getPickedCard() == null) {
//                    gameState.getCurrentPlayer().addTrainCard(gameState.getTrainCardDeck().drawCard(0));
//                    gameState.getCurrentPlayer().setTrainPoints(gameState.getCurrentPlayer().getTrainPoints()-1);
//                } else {
//
//                    if(graphicCards.getPickedCard().getColor().equals("wild")){
//                        if(gameState.getCurrentPlayer().getTrainPoints()==2) {
//                            gameState.getCurrentPlayer().addTrainCard(graphicCards.getPickedCard());
//                            gameState.nextTurn();
//                            System.out.println("ok");
//                        }
//                    }
//                    else {
//                        if(!graphicCards.getPickedCard().getColor().equals("wild")) {
//                            gameState.getCurrentPlayer().addTrainCard(graphicCards.getPickedCard());
//                            gameState.getCurrentPlayer().setTrainPoints(gameState.getCurrentPlayer().getTrainPoints() - 1);
//                        }
//                    }
//                }
//            }
//
//            if(gameState.getTrainCardDeck().hasThreeWild())
//                gameState.getTrainCardDeck().resetFaceUpCards();
//
//            if(gameState.getCurrentPlayer().getTrainPoints()<1)
//                gameState.nextTurn();
//        }



    }



    public ArrayList<TrainCard> getFaceUpCards() {
        return faceUpCards;
    }


    public boolean hasThreeWild(){
        int cnt=0;
        for(int i=0;i<5;i++){
            if(faceUpCards.get(i).getColor().equals("wild"))
                cnt++;
        }
        if(cnt>=3)
            return true;
        return false;
    }


    public void resetFaceUpCards(){
            for(int i=0;i<5;i++){
                deck.add(faceUpCards.remove(i));
                faceUpCards.add(drawCard(0));
            }
            shuffle();
    } // FIX THIS THIS HAS A BUG





}

