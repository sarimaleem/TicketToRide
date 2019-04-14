import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsBoard extends JPanel implements MouseListener {
    public static void main(String[] args) {
        JFrame window = new JFrame("GraphicsBoard"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        GraphicsBoard board = new GraphicsBoard();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.addMouseListener(board);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
