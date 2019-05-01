import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public class GraphicFaceUpCards extends JPanel {
    TrainCardDeck deck;

    public GraphicFaceUpCards(TrainCardDeck d) {
        deck = d;
    }

    public void draw(Graphics2D graphics2D) {
        drawGraphicCards(graphics2D);
    }

    public void drawGraphicCards(Graphics2D graphics2D) {
        drawRectangle(graphics2D,1720,340,170,670);
        int y = 350;
        ArrayList<TrainCard> faceUpCards = deck.getFaceUpCards();
        for (int i = 0; i < 5; i++) {
            GraphicTrainCard graphicTrainCard = new GraphicTrainCard(faceUpCards.get(i), 1730, y, false);
            graphicTrainCard.draw(graphics2D);
            y += 110;
        }
        drawRectangle(graphics2D,1730,900,150,100);
        graphics2D.drawString("Draw",1770,940);
        graphics2D.drawString("Train Card",1740,980);
    }
    public void drawRectangle(Graphics2D graphics2D,int x,int y, int w, int h){
        graphics2D.setColor(new Color(240,234,214));
        graphics2D.fillRect(x, y , w, h);
        graphics2D.setColor(Color.black);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(x, y ,w, h);
    }

    public int getCardIndex(int x, int y) {
        int startY = 350;
        ArrayList<TrainCard> faceUpCards = deck.getFaceUpCards();

        if (x >= 1730 && x <= 1880 && y >= 900 && y <= 1000){
            return 5; // card from deck
        }

        for (int i = 0; i < 5; i++) {
            GraphicTrainCard graphicTrainCard = new GraphicTrainCard(faceUpCards.get(i), 1730, startY, false);

            if (graphicTrainCard.contains(x, y)) {
                return i;
            }

            startY += 110;
        }
        return -1;
    }

}
