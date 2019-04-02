import java.io.FileNotFoundException;

public class testTicketAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        Network n = new Network();
        Player p = new Player("red");

        City calgary = n.cities.get("Calgary");
        City vancouver = n.cities.get("Vancouver");
        City Winnipeg = n.cities.get("Winnipeg");


        for (Route route : calgary.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }
        for (Route route : vancouver.getRoutes()) {
            route.setOwner(p);
            System.out.println(route);
        }


        System.out.println(n.ticketFinished(vancouver,n.cities.get("Boston"), p));
    }
}
