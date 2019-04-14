import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsBoard extends JPanel implements MouseListener {

    private GameState gameState;
    private BufferedImage map;

    public GraphicsBoard() throws IOException {
        gameState = new GameState();
        map = ImageIO.read(new File("board.jpg"));
        addMouseListener(this);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;






        try {
            paintBoard(graphics2D);
            drawGraphicPlayer(graphics2D);
        } catch (Exception e) {

        }
        drawCurrentPlayerContracts(graphics2D);



        repaint();
    }

    public void drawCurrentPlayerContracts(Graphics2D graphics2D) {
        double x = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().x;
        double y = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().y;

        if (!(x > 121 && x < 271 && y > 949 && y < 998)) return;

        int ticketX = 100;
        int ticketY = 100;


        for (Ticket ticket : gameState.getCurrentPlayer().getTickets()) {
            GraphicTicket graphicTicket = new GraphicTicket(ticket);
            graphicTicket.drawTicket(graphics2D, (int)ticketX, (int)ticketY);
            ticketX += 300;

            if (ticketX > 1800) {
                ticketX = 100;
                ticketY += 300;
            }
        }

    }





    public void paintBoard(Graphics2D graphics2D) {
        Font myFont = new Font("Serif", Font.BOLD, 25);
        graphics2D.setFont(myFont);
        graphics2D.drawImage(map, 0, 0, getWidth() - 500, getHeight() - 300, this);
        graphics2D.setColor(new Color(100, 50, 50));
        graphics2D.setFont(new Font("serif", Font.BOLD, 60));
//      graphics2D.drawString("Ticket To Ride", 600, 70);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(Color.BLACK);
        gameState.getNetwork().drawRoutes(graphics2D);
    }

    public void drawGraphicPlayer(Graphics2D graphics2D) throws IOException {
        GraphicPlayer graphicPlayer = new GraphicPlayer(gameState.getCurrentPlayer());
        graphicPlayer.draw(graphics2D);
    }

    public void mousePressed(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
        int x =e.getX();
        int y =e.getY();
        System.out.println(x + " " + y);
        gameState.getNetwork().printRoute(x, y);
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {

    }
}
