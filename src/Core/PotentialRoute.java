import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PotentialRoute {
    int x, y;
    Player player;
    Route route;
    String cardColorTradingIn;
    static final int width = 25, height = 25;

    public PotentialRoute(String color, Player player, Route route) {
        this.player = player;
        this.route = route;
        this.cardColorTradingIn = color;
        setCoordinates(color);
    }

    public void setCoordinates(String color) {
        int blueCardX = 435;
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
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(x+5, y+12, x+20, y+12);
        graphics2D.drawLine(x+12, y+5, x+12, y+20);
    }


    public boolean contains(int x, int y) {
        Ellipse2D.Double e = new Ellipse2D.Double(this.x, this.y, width, height);
        return e.contains(x, y);
    }

    public void activate() {

        int length = route.getLength();

        if (player.getNumTrainCard(cardColorTradingIn) - length >= 0) {
            player.removeTrainCards(cardColorTradingIn, length);
        } else {
            int numNormalCards = player.getNumTrainCard(cardColorTradingIn);
            int wildCardsNeeded = length - numNormalCards;
            player.removeTrainCards(cardColorTradingIn, numNormalCards);
            player.removeTrainCards("wild", wildCardsNeeded);
        }

        route.setOwner(player);

        //adding points
        switch (length) {
            case 1:
                player.setPoints(player.getPoints() + 1);
                break;
            case 2:
                player.setPoints(player.getPoints() + 2);
                break;
            case 3:
                player.setPoints(player.getPoints() + 4);
                break;
            case 4:
                player.setPoints(player.getPoints() + 7);
                break;
            case 5:
                player.setPoints(player.getPoints() + 10);
                break;
            case 6:
                player.setPoints(player.getPoints() + 15);
                break;
        }

        player.subtractNumTrains(length);
        player.clearPotentialRoutes();
    }


}
