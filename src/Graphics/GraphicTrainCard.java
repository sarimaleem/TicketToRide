import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphicTrainCard extends JPanel {
    private TrainCard trainCard;
    private int x, y;
    private static final int height = 150, width = 250;
    private BufferedImage image;

    public GraphicTrainCard(TrainCard trainCard, int xv, int yv) {
        x=xv;
        y=yv;

        String r="C:\\Users\\slhscs292\\Pictures\\colorcards\\"+trainCard.getColor()+"Card.png";
        try {
            File f = new File(r);
            image = ImageIO.read(f);

        }catch(IOException ex) {
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, x, y, width,height , this);
    }

    public boolean contains(int x, int y) {
        if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
            return true;
        }
        return false;
    }


}

