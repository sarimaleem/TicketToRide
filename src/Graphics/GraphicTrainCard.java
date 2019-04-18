import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphicTrainCard extends JPanel {
    private TrainCard trainCard;
    private int x, y;
    private static final int height = 150, width = 250, vheight = 150, vwidth = 100;
    private BufferedImage image;
    private boolean vertical;

    public GraphicTrainCard(TrainCard trainCard, int xv, int yv, boolean v) {
        x=xv;
        y=yv;
        vertical=v;
        String r;
        if(vertical)
            r="v"+trainCard.getColor()+"Card.png";
        else
            r=trainCard.getColor()+"Card.png";
        try {
            File f = new File(r);
            image = ImageIO.read(f);

        }catch(IOException ex) {
        }
    }

    public void draw(Graphics2D graphics2D) {
        drawTrainCard(graphics2D);
    }

    public boolean contains(int x, int y) {
        if(vertical){
            if (x >= this.x && x <= this.x + vwidth && y >= this.y && y <= this.y + vheight) {
                return true;
            }
            return false;
        }
        else {
            if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
                return true;
            }
            return false;
        }
    }

    public void drawTrainCard(Graphics2D graphics2D){
        if(vertical)
            graphics2D.drawImage(image, x, y, vwidth,vheight , this);
        else
            graphics2D.drawImage(image, x, y, width,height , this);
    }


}

