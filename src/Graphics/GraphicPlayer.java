import java.awt.*;

public class GraphicPlayer {
    private Player player;
    private int x, y;
    private static final int height = 200, width = 400;


    public GraphicPlayer(Player p, int xv, int yv) {
        player = p;
        x = xv;
        y = yv;
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
        graphics2D.fillRect(x, y , width, height);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(x, y , width, height);
        Font myFont = new Font("Courier", Font.BOLD, 35);
        graphics2D.setFont(myFont);
        graphics2D.drawString("PLAYER "+player.getTrainColor().toUpperCase(), 55, 860);
        myFont = new Font("Courier", Font.BOLD, 25);
        graphics2D.setFont(myFont);
        graphics2D.drawString(""+player.getPoints()+" POINTS", 135, 930);
    }

    public boolean contains(int x, int y) {
        if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
            return true;
        }
        return false;
    }




}
