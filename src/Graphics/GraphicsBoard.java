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
    private GraphicDrawTicket contracts;
    private GraphicOpeningDrawTicket open;
    private boolean GraphicsDrawTicketIsRunning,start;
    private int egg;
    public GraphicsBoard() throws IOException {
        gameState = new GameState();
        map = ImageIO.read(new File("board.jpg"));
        addMouseListener(this);
        open = new GraphicOpeningDrawTicket(gameState);
        GraphicsDrawTicketIsRunning =false;
        start=true;
        egg=0;
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
        drawCurrentPlayerContracts(graphics2D);
        if(start){
            open.paint(graphics2D);
            if(open.getContracts()!=null){
                for(Ticket t: open.getContracts())
                    gameState.getCurrentPlayer().addTicket(t);
                if(egg!=3){
                    open.reset();
                }
                gameState.nextTurn();
                egg++;
            }
        }
        if(egg==4){
            start=false;
            gameState.setTicketDeck(open.ReturnRemainingDeck());
            contracts=new GraphicDrawTicket(gameState);
            egg++;
        }
        drawDeck(graphics2D);
        if(GraphicsDrawTicketIsRunning){
            contracts.paint(graphics2D);
            if(contracts.getContracts()!=null){
                for(Ticket t: contracts.getContracts())
                    gameState.getCurrentPlayer().addTicket(t);
                GraphicsDrawTicketIsRunning =false;
                contracts.reset();
                gameState.nextTurn();
            }
        }
        repaint();
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
        Font myFont = new Font("Arial", Font.BOLD, 25);
        graphics2D.setFont(myFont);
        int adjX = 00;
        graphics2D.setColor(new Color(240,234,214));
        graphics2D.fillRect(1700-adjX,900,200,100);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(1700-adjX,900,200,100);
        graphics2D.drawString("Draw",1710-adjX,940);
        graphics2D.drawString("Contracts",1710-adjX,980);
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
    public void mousePressed(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
        int x =e.getX();
        int y =e.getY();
        System.out.println(x + " " + y);
        if(start){
            open.mouseReleased(e);
        }else {
            if (x >= 1700 && x <= 1900 && y >= 900 && y <= 1000 && !GraphicsDrawTicketIsRunning) {
                GraphicsDrawTicketIsRunning = true;
            }
            if (GraphicsDrawTicketIsRunning) {
                contracts.mouseReleased(e);
            } else {
                gameState.getNetwork().printRoute(x, y);
            }
        }
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {

    }
}
