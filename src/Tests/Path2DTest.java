import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Path2D;

public class Path2DTest extends JPanel implements MouseListener {

    static Path2D.Double test = new Path2D.Double();

    public static void main(String[] args) {
        JFrame window = new JFrame("Path2DTest"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        Path2DTest board = new Path2DTest();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.addMouseListener(board);


        int[] x = new int[]{100, 100, 200, 200};
        int[] y = new int[]{100, 200, 200, 100};

        createPath(test, x, y);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.draw(test);
        repaint();
    }

    public static void createPath(Path2D.Double p, int[] x, int[] y) {
        p.moveTo(x[0], y[0]);

        for (int i = 1; i < x.length; i++) {
            p.lineTo(x[i], y[i]);
        }

        p.closePath();

    }



    public void mouseClicked(MouseEvent e) {
        if (test.contains(new Point(e.getX(), e.getY()))) {
            System.out.println("SUCCESS");
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
