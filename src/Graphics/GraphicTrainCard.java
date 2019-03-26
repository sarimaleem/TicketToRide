import java.awt.*;

public class GraphicTrainCard {
    private TrainCard trainCard;
    private int x, y;
    private static final int height = 200, width = 100;


    public GraphicTrainCard(TrainCard trainCard, int x, int y) {
        this.trainCard = trainCard;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D graphics2D) {
        String color = traincard.getColor();

        switch (color) {
            case "green":
                graphics2D.setColor(Color.GREEN);
                break;
            case "blue":
                graphics2D.setColor(Color.BLUE);
                break;
        }

        graphics2D.fillRect(x, y, width, height);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRect(x, y, width, height);
    }

    public boolean contains(int x, int y) {
        if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
            return true;
        }
        return false;
    }
}
