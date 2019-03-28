import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicTrainCardRunner extends JPanel implements MouseListener {


    TrainCard t = new TrainCard("blue");


    public static void main(String[] args) {
        JFrame window = new JFrame("GraphicTrainCardRunner"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        GraphicTrainCardRunner board = new GraphicTrainCardRunner();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.addMouseListener(board);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawGraphicTrainCard(graphics2D);
        repaint();
    }

    public void drawGraphicTrainCard(Graphics2D graphics2D) {
        GraphicTrainCard graphicsClass = new GraphicTrainCard(t, 1670, 0);
        graphicsClass.draw(graphics2D);
    }

    public void mouseClicked(MouseEvent e) {
        GraphicTrainCard sampleGraphicsClass = new GraphicTrainCard(t, 1670, 0);
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

