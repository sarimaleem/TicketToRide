import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicPlayerRunner extends JPanel implements MouseListener {


    Player player = new Player("yellow");


    public static void main(String[] args) {
        JFrame window = new JFrame("SampleTestClass"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        SampleTestClass board = new SampleTestClass();
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
        GraphicPlayer graphicsClass = new GraphicPlayer(player, 500, 500);
        graphicsClass.draw(graphics2D);
    }

    public void mouseClicked(MouseEvent e) {
        GraphicPlayer graphicsClass = new GraphicPlayer(player, 500, 500);
        System.out.println(e.getX() +" " + e.getY());

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

