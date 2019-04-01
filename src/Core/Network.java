import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Network
{
    private HashMap<String, City> cities;
    private HashMap<Path2D.Double, Route> paths;

    public Network() throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("Routes.txt"));
        for(int i = 0; i < 1; i++)
        {
            String s = in.nextLine();
            String[] temp = s.split(" ");
            City city = new City(temp[1]);
            City city2 = new City(temp[1]);

        }
    }
}
