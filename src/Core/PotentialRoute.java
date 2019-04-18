import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PotentialRoute {
    int x, y;
    Player player;
    Route route;
    static final int width = 25, height = 25;

    public PotentialRoute(String color, Player player, Route route) {
        this.player = player;
        this.route = route;
        setCoordinates(color);
    }

    public void setCoordinates(String color) {
        int blueCardX = 455;
        if (color.equals("blue")) x = blueCardX;
        else if(color.equals("green")) x = blueCardX + 115;
        else if(color.equals("black")) x = blueCardX + 115*2;
        else if(color.equals("orange")) x = blueCardX + 115*3;
        else if(color.equals("purple")) x = blueCardX + 115*4;
        else if(color.equals("red")) x = blueCardX + 115*5;
        else if(color.equals("white")) x = blueCardX + 115*6;
        else if(color.equals("yellow")) x = blueCardX + 115*7;

        y = 770;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(0, 204, 202));
        graphics2D.fillOval(x, y, width, height);
    }


    public boolean contains(int x, int y) {
        Ellipse2D.Double e = new Ellipse2D.Double(this.x, this.y, width, height);
        return e.contains(x, y);
    }

    public void activate() {

        int length = route.getLength();
        String color = route.getColor();

        if (player.getNumTrainCard(color) - length >= 0) {
            player.removeTrainCards(color, length);
        } else {
            int numNormalCards = player.getNumTrainCard(color);
            int wildCardsNeeded = length - numNormalCards;
            player.removeTrainCards(color, numNormalCards);
            player.removeTrainCards("wild", wildCardsNeeded);
        }

        route.setOwner(player);
        player.clearPotentialRoutes();
    }


}
