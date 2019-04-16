import java.awt.*;
import java.awt.geom.Ellipse2D;

public class potentialRoute {
    int x, y;
    Player player;
    Route route;

    public potentialRoute(String color, Player player, Route route) {
        this.player = player;
        this.route = route;
        setCoordinates(color);
    }

    public void setCoordinates(String color) {
        if (color.equals("blue")) x = 465;
        else if(color.equals("green")) x = 465 + 115;
        else if(color.equals("black")) x = 465 + 115*2;
        else if(color.equals("orange")) x = 465 + 115*3;
        else if(color.equals("purple")) x = 465 + 115*4;
        else if(color.equals("red")) x = 465 + 115*5;
        else if(color.equals("white")) x = 465 + 115*6;
        else if(color.equals("yellow")) x = 465 + 115*7;

        y = 770;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillOval(x, y, 100, 100);
    }


    public boolean contains(int x, int y) {
        Ellipse2D.Double e = new Ellipse2D.Double(this.x, this.y, 100, 100);
        return e.contains(x, y);
    }


}
