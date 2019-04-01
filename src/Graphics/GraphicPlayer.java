import java.awt.*;

public class GraphicPlayer {
    private Player player;
    //private int x, y;
    //private static final int height = 230, width = 400;
    TrainCard b = new TrainCard("blue");
    TrainCard g = new TrainCard("green");
    TrainCard bl = new TrainCard("black");
    TrainCard o = new TrainCard("orange");
    TrainCard p = new TrainCard("purple");
    TrainCard r = new TrainCard("red");
    TrainCard w = new TrainCard("white");
    TrainCard wi = new TrainCard("wild");
    TrainCard ye = new TrainCard("yellow");


    public GraphicPlayer(Player p) {
        player = p;
    }

    public void draw(Graphics2D graphics2D) {
        String color = player.getTrainColor();
        switch (color) {
            case "green":
                graphics2D.setColor(Color.GREEN);
                break;
            case "blue":
                graphics2D.setColor(Color.BLUE);
                break;
            case "red":
                graphics2D.setColor(Color.RED);
                break;
            case "yellow":
                graphics2D.setColor(Color.YELLOW);
                break;
        }
        graphics2D.fillRect(5, 780 , 400, 230);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(5, 780 ,400, 230);
        Font myFont = new Font("Courier", Font.BOLD, 35);
        graphics2D.setFont(myFont);
        graphics2D.drawString("PLAYER "+player.getTrainColor().toUpperCase(), 55, 860);
        myFont = new Font("Courier", Font.BOLD, 25);
        graphics2D.setFont(myFont);
        graphics2D.drawString(""+player.getPoints()+" POINTS", 135, 930);
        graphics2D.fillRect(1450, 780 , 200, 230);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(1450, 780 ,200, 230);
        GraphicTrainCard blue = new GraphicTrainCard(b, 415, 850,true);
        GraphicTrainCard green = new GraphicTrainCard(g, 530, 850,true);
        GraphicTrainCard black = new GraphicTrainCard(bl, 645, 850,true);
        GraphicTrainCard orange = new GraphicTrainCard(o, 760, 850,true);
        GraphicTrainCard purple = new GraphicTrainCard(p, 875, 850,true);
        GraphicTrainCard red = new GraphicTrainCard(r, 990, 850,true);
        GraphicTrainCard white = new GraphicTrainCard(w, 1105, 850,true);
        GraphicTrainCard wild = new GraphicTrainCard(wi, 1220, 850,true);
        GraphicTrainCard yellow = new GraphicTrainCard(ye, 1335, 850,true);
        blue.draw(graphics2D);
        green.draw(graphics2D);
        black.draw(graphics2D);
        orange.draw(graphics2D);
        purple.draw(graphics2D);
        red.draw(graphics2D);
        white.draw(graphics2D);
        wild.draw(graphics2D);
        yellow.draw(graphics2D);
    }

   // public boolean contains(int x, int y) {
    //    if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
    //        return true;
   //     }
    //    return false;
  //  }




}
