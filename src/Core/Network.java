import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Network {
    HashMap<String, City> cities;
    HashMap<Path2D.Double, Route> paths;
    public Network() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Routes.txt"));
        cities = new HashMap<>();
        paths = new HashMap<>();

        int i = 0;

        while(in.hasNextLine()) {

            System.out.println(++i);
            String s = in.nextLine();
            String[] temp = s.split(" ");

            String name1 = temp[0];
            String name2 = temp[1];
            int length = Integer.parseInt(temp[2]);
            String color = temp[3];

            if (cities.get(name1) == null) {
                cities.put(name1, new City(name1));
            }

            if (cities.get(name2) == null) {
                cities.put(name2, new City(name2));
            }

            Route r = new Route(cities.get(name1), cities.get(name2), color, length);
            cities.get(name1).addRoute(r);
            cities.get(name2).addRoute(r);

        }

    }
}
