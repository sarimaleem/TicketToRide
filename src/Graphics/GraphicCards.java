import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;

public class GraphicCards extends JPanel {
    TrainCardDeck deck;
    //ArrayList<TrainCard> cards=new ArrayList<TrainCard>();
    // a = new TrainCard("blue");
    //TrainCard b = new TrainCard("green");
    //TrainCard c = new TrainCard("black");
    // d = new TrainCard("orange");
    //TrainCard e = new TrainCard("purple");


    public GraphicCards() {
        deck=new TrainCardDeck();
        //cards.add(a);
        //cards.add(b);
        //cards.add(c);
        //cards.add(d);
        //cards.add(e);
    }
    public GraphicCards(TrainCardDeck d) {
        deck=d;
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
        int y=0;
        for(int i=0;i<5;i++){
            TrainCard t=deck.drawCard();
            GraphicTrainCard a=new GraphicTrainCard(t,1670,y,false);
            a.draw(graphics2D);
            y+=(160);
        }

    }

    //public boolean contains(int x, int y) {
     //   if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
     //       return true;
     //   }
     //   return false;
    //}

//HI this is a test

}
