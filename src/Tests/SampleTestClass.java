import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SampleTestClass extends JPanel implements MouseListener {


    SampleCoreClass sampleCoreClass = new SampleCoreClass("green");


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
        drawSampleCoreClass(graphics2D);
        repaint();
    }

    public void drawSampleCoreClass(Graphics2D graphics2D) {
        SampleGraphicsClass graphicsClass = new SampleGraphicsClass(sampleCoreClass, 500, 500);
        graphicsClass.draw(graphics2D);
    }

    public void mouseClicked(MouseEvent e) {
        SampleGraphicsClass sampleGraphicsClass = new SampleGraphicsClass(sampleCoreClass, 500, 500);
        System.out.println(e.getX() +" " + e.getY());
        if(sampleGraphicsClass.contains(e.getX(), e.getY()))
            sampleCoreClass.switchColor();

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
