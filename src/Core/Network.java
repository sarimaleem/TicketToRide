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
    HashSet<Route> marked;






    public Network() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Routes.txt"));

        cities = new HashMap<>();
        paths = new HashMap<>();
        marked = new HashSet<>();

        int i = 0;

        while(in.hasNextLine()) {

            String name1 = in.next();
            String name2 = in.next();
            int length = in.nextInt();
            String color = in.next();

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

    public void printRoute(int x, int y) {
        for (Path2D.Double p : paths.keySet()) {
            if (p.contains(x, y)) {
                System.out.println(paths.get(p).getA().name + " " + paths.get(p).getB().name);
            }
        }
    }

    public boolean ticketFinished(City start, City end, Player p) {
        String trainColor = p.getTrainColor();
        boolean complete = false;
        if (start == end) complete = true;

        for (Route r : start.getRoutes()) {
            if(!r.isFull()) {
                continue;
            } else if(marked.contains(r)) {
                continue;
            } else if (!p.getTrainColor().equals(r.getOwner().getTrainColor())) {
                continue;
            } else {
                marked.add(r);
                complete = complete || ticketFinished(r.getOtherCity(start), end, p);
            }
        }
        return complete;
    }
}
