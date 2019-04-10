import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicPlayerRunner extends JPanel implements MouseListener {


    Player player = new Player("yellow");
    private static JFrame window;
    //TrainCard b = new TrainCard("blue");
    //TrainCard g = new TrainCard("green");


    public static void main(String[] args) {
        window = new JFrame("GraphicPlayerRunner"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        window.setBackground(Color.GRAY);
        GraphicPlayerRunner board = new GraphicPlayerRunner();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.addMouseListener(board);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawGraphicPlayer(graphics2D);
        repaint();
    }

    public void drawGraphicPlayer(Graphics2D graphics2D) {
        GraphicPlayer graphicPlayer = new GraphicPlayer(player);
        graphicPlayer.draw(graphics2D);
    }

    public void mouseClicked(MouseEvent e) {
        GraphicPlayer graphicPlayer = new GraphicPlayer(player);
        if(graphicPlayer.contains(e.getX(),e.getY())) {
            graphicPlayer.ticketClicked();
            window.repaint();
            System.out.println("hi");
        }

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}

