import java.io.FileNotFoundException;

public class testTicketAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        Network n = new Network();
        Player p = new Player("red");

        City calgary = n.cities.get("Calgary");
        City vancouver = n.cities.get("Vancouver");
        City Winnipeg = n.cities.get("Winnipeg");
        City Helena = n.cities.get("Helena");
        City Denever = n.cities.get("Denver");
        City Omaha = n.cities.get("Omaha");
        City Pittsburgh = n.cities.get("Pittsburgh");
        City Raleigh = n.cities.get("Raleigh");





        for (Route route : calgary.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }
        for (Route route : vancouver.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }

        for (Route route : Winnipeg.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }

        for (Route route : Helena.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }

        for (Route route : vancouver.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }










        System.out.println(n.ticketFinished(vancouver,n.cities.get("Helena"), p));
    }
}
