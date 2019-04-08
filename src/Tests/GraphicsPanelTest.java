
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Path2D;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class GraphicsPanelTest extends JPanel implements MouseListener{
    private BufferedImage map;
    private ArrayList<BufferedImage> cards;
    private Network n;
    private int x,y;
    public GraphicsPanelTest() throws FileNotFoundException {
        x=0;
        y=0;
        cards = new ArrayList<>();
        try {
            map = ImageIO.read(new File("board.jpg"));
            cards.add(ImageIO.read(new File("black.png")));
            cards.add(ImageIO.read(new File("white.png")));
            cards.add(ImageIO.read(new File("blue.png")));
            cards.add(ImageIO.read(new File("green.png")));
            cards.add(ImageIO.read(new File("orange.png")));
            cards.add(ImageIO.read(new File("purple.png")));
            cards.add(ImageIO.read(new File("wild.png")));
            cards.add(ImageIO.read(new File("yellow.png")));
            cards.add(ImageIO.read(new File("red.png")));

        }catch(IOException ex) {

        }
        addMouseListener(this);
        n = new Network();
    }
    public void paint(Graphics g) {
        paintBoard(g);

    }
    public void paintBoard(Graphics g) {
        Font myFont = new Font("Serif", Font.BOLD, 25);
        g.setFont(myFont);
        g.drawImage(map, 0, 100, getWidth() - 500, getHeight() - 300, this);
        g.setColor(new Color(100, 50, 50));
        g.setFont(new Font("serif", Font.BOLD, 60));
        g.drawString("Ticket To Ride", 800, 70);
        for(int i = 0; i < cards.size(); i++)
        {
            g.drawImage(cards.get(i), 200, getHeight()-200, 100, 200, this);
        }
        paintRoutes(g, x , y);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(Color.BLACK);
        n.drawRoutes(graphics2D);
        repaint();

    }
    public void paintRoutes(Graphics g, int x, int y) {
        HashMap<Path2D.Double, Route> paths = n.getPaths();
        for (Path2D.Double p : paths.keySet()) {
            if (p.contains(x, y)) {
                if(paths.get(p).getColor().equals("gray"))
                    g.setColor(Color.GRAY);
                if(paths.get(p).getColor().equals("blue"))
                    g.setColor(Color.BLUE);
                if(paths.get(p).getColor().equals("black"))
                    g.setColor(Color.BLACK);
                if(paths.get(p).getColor().equals("white"))
                    g.setColor(Color.WHITE);
                if(paths.get(p).getColor().equals("red"))
                    g.setColor(Color.RED);
                if(paths.get(p).getColor().equals("yellow"))
                    g.setColor(Color.YELLOW);
                if(paths.get(p).getColor().equals("orange"))
                    g.setColor(Color.ORANGE);
                if(paths.get(p).getColor().equals("purple"))
                    g.setColor(Color.PINK);
                if(paths.get(p).getColor().equals("green"))
                    g.setColor(Color.GREEN);
                g.drawString(paths.get(p).getA().name + " - " + paths.get(p).getB().name,500, 500);
            }
        }
    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
        x=e.getX();
        y=e.getY();
        System.out.println(x + " " + y);
        n.printRoute(x, y);
        repaint();
    }

}