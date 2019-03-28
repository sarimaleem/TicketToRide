import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Route> routes;

    public City(String name) {
        this.name = name;
        routes = new ArrayList<>();
    }

    public City(String name, ArrayList<Route> routes) {
        this.name = name;
        this.routes = routes;
    }

    public void addRoute(Route r) {
        routes.add(r);
    }


    public ArrayList<Route> getRoutes() {
        return routes;
    }


    public String toString() {
        return name + " " + routes;
    }


}
