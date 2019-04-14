import java.io.IOException;
import java.util.ArrayList;
public class DrawTest {
    public static void main(String[]args) throws IOException{
        ArrayList<Ticket> tester;
        DrawTicket test = new DrawTicket();
        tester=test.drawTickets();
        for(int x=0;x<tester.size();x++){
            System.out.println(tester.get(x));
        }
    }
}
