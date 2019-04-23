import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;

public class GraphicFaceUpCards extends JPanel {
    TrainCardDeck deck;
    GraphicTrainCard picked;
    //ArrayList<TrainCard> cards=new ArrayList<TrainCard>();
    // a = new TrainCard("blue");
    //TrainCard b = new TrainCard("green");
    //TrainCard c = new TrainCard("black");
    // d = new TrainCard("orange");
    //TrainCard e = new TrainCard("purple");


    public GraphicFaceUpCards() {
        deck = new TrainCardDeck();
    }

    public GraphicFaceUpCards(TrainCardDeck d) {
        deck = d;
        //displayedCards=new ArrayList<>();
        //for(int i=0;i<5;i++){
        //TrainCard t=deck.drawCard();
        //  displayedCards.set(i,deck.drawCard());
        //}
        //cards.add(a);
        //cards.add(b);
        //cards.add(c);
        //cards.add(d);
        //cards.add(e);
    }

    public void draw(Graphics2D graphics2D) {
        drawGraphicCards(graphics2D);
    }

    public void drawGraphicCards(Graphics2D graphics2D) {
        int y = 350;
        ArrayList<TrainCard> faceUpCards = deck.getFaceUpCards();
        for (int i = 0; i < 5; i++) {
            GraphicTrainCard graphicTrainCard = new GraphicTrainCard(faceUpCards.get(i), 1600, y, false);
            graphicTrainCard.draw(graphics2D);
            y += 110;
        }

    }

    public boolean contains(int x, int y) {
        boolean c = false;
        ArrayList<TrainCard> faceUpCards = deck.getFaceUpCards();
        for (int i = 0; i < 5; i++) {
            GraphicTrainCard graphicTrainCard = new GraphicTrainCard(faceUpCards.get(i), 1600, y, false);
            y += 110;
            if (graphicTrainCard.contains(x, y)) {
                picked=graphicTrainCard;
                deck.drawFaceUpCard(i);
                return true;

            }

        }
        return false;
    }

//HI this is a test

}
