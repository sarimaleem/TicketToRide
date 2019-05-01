import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GraphicsBoard extends JPanel implements MouseListener {

    private GameState gameState;
    private BufferedImage map;
    HashMap<String, Color> colorHashMap;

    public GraphicsBoard() throws IOException {
        gameState = new GameState();
        map = ImageIO.read(new File("board.jpg"));
        addMouseListener(this);

        colorHashMap = new HashMap<>();

        colorHashMap.put("red", Color.red);
        colorHashMap.put("blue", Color.blue);
        colorHashMap.put("green", Color.green);
        colorHashMap.put("yellow", Color.yellow);




    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawBoard(graphics2D);
        try {
            drawGraphicPlayer(graphics2D);
        } catch (IOException e) {
            e.printStackTrace();
        }
        drawDeck(graphics2D);
        try {
            drawGraphicCards(graphics2D);
        } catch (IOException e) {
            e.printStackTrace();
        }
        drawCurrentPlayerContracts(graphics2D);
        repaint();

        drawCheatStatistics(graphics2D);




    }

    public void drawCurrentPlayerContracts(Graphics2D graphics2D) {
        double x = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().x;
        double y = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().y;

        if (!(x > 120 && x < 270 && y > 945 && y < 1000)) {
            return;
        }

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

    public void drawDeck(Graphics2D graphics2D) {

        int adjX = 230;

        graphics2D.setColor(new Color(240,234,214));
        graphics2D.fillRect(1700-adjX,900,150,100);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(1700-adjX,900,150,100);
        graphics2D.drawString("Draw",1710-adjX,940);
        graphics2D.drawString("Contracts",1710-adjX,980);
    }

    public void drawCheatStatistics(Graphics2D graphics2D) {

        String[] colors = {"blue", "green", "black", "orange", "purple", "red", "white", "yellow", "wild"};

        double hoverX = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX();
        double hoverY = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY();

        graphics2D.drawRect(1462, 914, 62, 63);
        graphics2D.drawString("Cheat", 1465, 950);


        if (hoverX > 1462 && hoverX < 1526 && hoverY > 914 && hoverY < 977) {
            int y = 775;
            for (Player player : gameState.getPlayers()) {
                graphics2D.setColor(colorHashMap.get(player.getTrainColor()));
                int c=500;
                for(int i=0;i<9;i++){
                    graphics2D.drawString(""+player.getNumTrainCard(colors[i]), c, y);
                    c += 115;
                }
                y += 20;
            }
        }
    }





    public void drawBoard(Graphics2D graphics2D) {
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

    public void drawGraphicCards(Graphics2D graphics2D) throws IOException {
        GraphicFaceUpCards graphicCards=new GraphicFaceUpCards(gameState.getTrainCardDeck());
        graphicCards.draw(graphics2D);
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

        GraphicFaceUpCards graphicCards = new GraphicFaceUpCards(gameState.getTrainCardDeck());
        int pickedCardIndex = graphicCards.getCardIndex(x, y);
        gameState.getTrainCardDeck().drawFaceUpCard(pickedCardIndex, gameState.getCurrentPlayer());

        if (gameState.getCurrentPlayer().getTrainPoints() == 0) {
            gameState.nextTurn();
        }

    }




    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {

    }
}
