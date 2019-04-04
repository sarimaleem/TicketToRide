public class Route {
    private int length;
    private City a;
    private City b;
    private boolean full;
    private Player owner;
    private String color;

    public Route (City a, City b, String color, int length) {
        this.length = length;
        this.a = a;
        this.b = b;
        this.full = false;
        this.owner = null;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public City getA() {
        return a;
    }

    public City getB() {
        return b;
    }

    public boolean isFull() {
        return full;
    }

    public City getOtherCity(City c) {
        if(c == a)
            return b;
        return a;
    }

    public Player getOwner() {
        return owner;
    }
    public String getColor() {
        return color;
    }



}
