
import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Route> routes;

    public City(String name, ArrayList<Route> routes) {
        this.name = name;
        this.routes = routes;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }
}
