import java.awt.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Network {
    HashMap<String, City> cities;
    HashMap<Path2D.Double, Route> paths;
    HashMap<String, Color> stringColorHashMap;
    HashSet<Route> marked;


    public Network() throws FileNotFoundException {

        Scanner in = new Scanner(new File("Routes.txt"));
        cities = new HashMap<>();
        paths = new HashMap<>();
        stringColorHashMap = new HashMap<>();
        stringColorHashMap.put("red", Color.red);
        stringColorHashMap.put("blue", Color.blue);
        stringColorHashMap.put("yellow", Color.yellow);
        stringColorHashMap.put("green", Color.green);


        int i = 0;

        while (in.hasNextLine()) {

            String[] temp = in.nextLine().split("-");
            System.out.println(i);

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

            if (i < 100) {

                Path2D.Double test = new Path2D.Double();
                test.moveTo(in.nextInt(), in.nextInt() - 100);

                while (in.hasNextInt()) {
                    test.lineTo(in.nextInt(), in.nextInt() - 100);
                }

                test.closePath();
                paths.put(test, r);
                i++;
            }
            if (i < 100)
                in.nextLine();
        }

    }

    public HashMap getPaths() {
        return paths;
    }

    public void printRoute(int x, int y) {
        for (Path2D.Double p : paths.keySet()) {
            if (p.contains(x, y)) {
                System.out.println(paths.get(p).getA().name + " " + paths.get(p).getB().name + " " + paths.get(p).getColor());
            }
        }
    }

    public Route getRoute(int x, int y) {
        for (Path2D.Double p : paths.keySet()) {
            if (p.contains(x, y)) {
                return paths.get(p);
            }
        }
        return null;
    }


    public void drawAndFillRoutes(Graphics2D graphics2D) {
        for (Path2D.Double p : paths.keySet()) {
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(p);
            if (paths.get(p).getOwner() != null) {
                graphics2D.setColor(stringColorHashMap.get(paths.get(p).getOwner().getTrainColor()));
                graphics2D.fill(p);
            }
        }
    }

    public boolean ticketFinished(String start, String end, Player p) {

        boolean complete = false;
        if (start.equals(end)) complete = true;

        System.out.println("start: " + start + "End: " + end);
        for (Route r : cities.get(start).getRoutes()) {

            System.out.println("route: " + r.getA().getName() + " " + r.getB().getName());

            if(!r.isFull()) {
                continue;
            } else if(marked.contains(r)) {
                continue;
            } else if (!(p == r.getOwner())) {
                continue;
            } else {
                marked.add(r);
                complete = complete || ticketFinished(r.getOtherCity(cities.get(start)).getName(), end, p);
            }
        }

        System.out.println(complete);

        return complete;
    }

    public void highlight(Graphics2D graphics2D, int x, int y)
    {
        for (Path2D.Double p : paths.keySet()) {
            if (p.contains(x, y)) {
                graphics2D.setColor(Color.YELLOW);
                graphics2D.draw(p);
            }
        }
    }

    public Player longestPath(ArrayList<Player> players) {
        int max = 0;
        Player longestPathPlayer = null;

        for (Player p : players) {
            int longestPath = 0;
            for (City c : cities.values()) {
                HashSet<City> markedCities = new HashSet<>();
                longestPath = Math.max(longestPath, longestPath(p, c, markedCities));
            }

            if (longestPath > max) {
                longestPathPlayer = p;
                max = longestPath;
            }
        }

        return longestPathPlayer;

    }


    public int longestPath(Player p, City c, HashSet<City> markedCities) {

        if (markedCities.contains(c)) {
            return markedCities.size();
        }

        int longest = markedCities.size();

        for (Route r : c.getRoutes()) {
            if (r.getOwner() == p) {
                HashSet<City> m = (HashSet<City>) markedCities.clone();
                m.add(c);
                longest = Math.max(longest, longestPath(p, r.getOtherCity(c), m));
            }
        }

        return longest;

    }

    public void resetMarked() {
        marked = new HashSet<>();
    }

}
