import java.awt.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Network {
    HashMap<String, City> cities;
    HashMap<Path2D.Double, Route> paths;

    public Network() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Routes.txt"));
        cities = new HashMap<>();
        paths = new HashMap<>();

        int i = 0;

        while (in.hasNextLine()) {

            String[] temp = in.nextLine().split("-");

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

    public void highlight(Graphics2D graphics2D, int x, int y)
    {
        for (Path2D.Double p : paths.keySet()) {
            if (p.contains(x, y)) {
                graphics2D.setColor(Color.YELLOW);
                graphics2D.draw(p);
            }
        }
    }

    public void drawRoutes(Graphics2D graphics2D) {
        for (Path2D.Double p : paths.keySet()) {
            graphics2D.draw(p);
        }
    }
}
