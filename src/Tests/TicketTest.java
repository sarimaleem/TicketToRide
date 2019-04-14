import javax.swing.*;
import java.io.IOException;

public class TicketTest {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("TicketTest"); // Makes sure that you title this correctly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
        GraphicDrawTicketv2 board = new GraphicDrawTicketv2();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.addMouseListener(board);
    }
}
