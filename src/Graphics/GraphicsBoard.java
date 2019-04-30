import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;


public class GraphicsBoard extends JPanel implements MouseListener {
    
    private GameState gameState;
    private BufferedImage map;
    HashMap<String, Color> colorHashMap;
    private static int deckXAdj = 180;


    private GraphicDrawTicket contracts;
    private GraphicOpeningDrawTicket BeginningTicketSelection;
    private boolean GraphicsDrawTicketIsRunning,start;
    private int numTurnsPassed;

    public GraphicsBoard() throws IOException {

        gameState = new GameState();
        map = ImageIO.read(new File("board.jpg"));
        addMouseListener(this);

       // this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        colorHashMap = new HashMap<>();
        colorHashMap.put("yellow", Color.yellow);
        colorHashMap.put("blue", Color.blue);
        colorHashMap.put("green", Color.green);
        colorHashMap.put("red", Color.red);


        BeginningTicketSelection = new GraphicOpeningDrawTicket(gameState);
        GraphicsDrawTicketIsRunning =false;
        start=true;
        numTurnsPassed =0;


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

        drawPotentialRoutes(graphics2D);

        drawLeaderboard(gameState, graphics2D);

        drawCurrentPlayerContracts(graphics2D);

        if(start){
            BeginningTicketSelection.paint(graphics2D);
            if(BeginningTicketSelection.getContracts()!=null){
                for(Ticket t: BeginningTicketSelection.getContracts())
                    gameState.getCurrentPlayer().addTicket(t);
                if(numTurnsPassed !=3){
                    BeginningTicketSelection.reset();
                }
                gameState.nextTurn();
                numTurnsPassed++;
            }
        }

        if(numTurnsPassed == 4){
            start=false;
            gameState.setTicketDeck(BeginningTicketSelection.ReturnRemainingDeck());
            contracts=new GraphicDrawTicket(gameState);
            numTurnsPassed++;
        }

        drawDeck(graphics2D);

        drawCheatStatistics(graphics2D);

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



//        System.out.println(gameState.getCurrentPlayer().getPotentialRoutes());
    }

    public void drawCheatStatistics(Graphics2D graphics2D) {

        String[] colors = {"blue", "green", "black", "orange", "purple", "red", "white", "yellow", "wild"};

        double hoverX = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX();
        double hoverY = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY();

        graphics2D.drawRect(1442, 914, 62, 63);
        graphics2D.setFont(new Font("serif",Font.BOLD , 20));
        graphics2D.drawString("Cheat", 1445, 950);


        if (hoverX > 1442 && hoverX < 1506 && hoverY > 914 && hoverY < 977) {
            int y = 775;
            for (Player player : gameState.getPlayers()) {
                graphics2D.setColor(colorHashMap.get(player.getTrainColor()));
                int c=480;
                for(int i=0;i<9;i++){
                    graphics2D.drawString(""+player.getNumTrainCard(colors[i]), c, y);
                    c += 115;
                }
                y += 20;
            }
        }
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
            graphicTicket.drawTicket(graphics2D, ticketX, ticketY);
            ticketX += 300;
            if (ticketX > 1800) {
                ticketX = 100;
                ticketY += 300;
            }
        }
    }

    public void drawPotentialRoutes(Graphics2D graphics2D) {
        for (PotentialRoute potentialRoute : gameState.getCurrentPlayer().getPotentialRoutes()) {
            potentialRoute.draw(graphics2D);
        }
    }

    public void drawDeck(Graphics2D graphics2D) {

        graphics2D.setColor(new Color(240,234,214));
        graphics2D.fillRect(1700- deckXAdj,900,200,100);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(1700- deckXAdj,900,200,100);
        graphics2D.drawString("Draw",1710- deckXAdj,940);
        graphics2D.drawString("Contracts",1710- deckXAdj,980);
    }

    public void drawBoard(Graphics2D graphics2D) {
        this.setBackground(new Color(110, 160, 148));
        graphics2D.drawImage(map, 0, 0, getWidth() - 500, getHeight() - 300, this);
        graphics2D.setColor(new Color(62, 94, 100));
        graphics2D.fillRect(0, getHeight()-300, getWidth()-500, 300);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(1415, 0, 1415, getHeight());

        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(Color.BLACK);

        gameState.getNetwork().drawAndFillRoutes(graphics2D);
        graphics2D.setFont(new Font("serif", Font.BOLD, 60));
        graphics2D.drawString("Ticket To Ride", 1470, 70);


    }

    public void drawGraphicPlayer(Graphics2D graphics2D) throws IOException {
        GraphicPlayer graphicPlayer = new GraphicPlayer(gameState.getCurrentPlayer());
        graphicPlayer.draw(graphics2D);
    }

    public void drawLeaderboard(GameState game, Graphics2D graphics2D) {
        int adjY = 100;
        ArrayList<Player> players = game.getPlayers();
        graphics2D.drawRect(1414, adjY, 500, 320);
        graphics2D.setColor(Color.cyan);
        graphics2D.fillRect(1414, adjY, 500, 320);
        graphics2D.setColor(new Color(0, 0, 0));
        graphics2D.setFont(new Font("serif", Font.BOLD, 30));
        graphics2D.drawString("Leaderboard", 1570, 30+adjY);
        graphics2D.setFont(new Font("serif", Font.BOLD, 20));
        graphics2D.drawString(players.get(0).getTrainColor(),1465, 75+adjY);
        graphics2D.drawString(players.get(1).getTrainColor(),1735, 75+adjY);
        graphics2D.drawString(players.get(2).getTrainColor(),1465, 200+adjY);
        graphics2D.drawString(players.get(3).getTrainColor(),1735, 200+adjY);
        drawInfo(players.get(0), new Point(1465, 75+adjY), graphics2D);
        drawInfo(players.get(1), new Point(1735, 75+adjY), graphics2D);
        drawInfo(players.get(2), new Point(1465, 200+adjY), graphics2D);
        drawInfo(players.get(3), new Point(1735, 200+adjY), graphics2D);
    }

    private void drawInfo(Player player, Point point, Graphics2D graphics2D) {
        graphics2D.setFont(new Font("serif", Font.BOLD, 15));
        graphics2D.drawString("Points: ",(int)point.getX(), (int)point.getY()+30);
        graphics2D.drawString(""+player.getPoints(),(int)point.getX()+50, (int)point.getY()+30);
        graphics2D.drawString("Trains: ",(int)point.getX(), (int)point.getY()+50);
        graphics2D.drawString(""+player.getNumTrains(),(int)point.getX()+50, (int)point.getY()+50);
        graphics2D.drawString("Contracts Completed: ",(int)point.getX(), (int)point.getY()+70);
        graphics2D.drawString(""+player.numTicketsCompleted(),(int)point.getX()+150, (int)point.getY()+70);
        graphics2D.drawString("Contracts Remaining: ",(int)point.getX(), (int)point.getY()+90);
        graphics2D.drawString(""+player.numTicketsNotCompleted(),(int)point.getX()+150, (int)point.getY()+90);
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



        if(start){
            BeginningTicketSelection.mouseReleased(e);
        } else {
            if (x >= 1700- deckXAdj && x <= 1900- deckXAdj && y >= 900 && y <= 1000 && !GraphicsDrawTicketIsRunning) {
                gameState.clearPotentialRoutes();
                GraphicsDrawTicketIsRunning = true;
            }
            if (GraphicsDrawTicketIsRunning) {
                gameState.clearPotentialRoutes();
                contracts.mouseReleased(e);
            } else {
                gameState.getNetwork().printRoute(x, y);

                Route r = gameState.getNetwork().getRoute(x, y);

                if (r != null && r.getOwner() == null) {
                    gameState.getCurrentPlayer().makePotentialRoutes(r);
                }

                for (int i = 0; i < gameState.getCurrentPlayer().getPotentialRoutes().size(); i++) {
                    PotentialRoute p = gameState.getCurrentPlayer().getPotentialRoutes().get(i);
                    if (p.contains(x, y)) {
                        p.activate();
                        gameState.nextTurn();
                    }
                }

            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

    }
}
