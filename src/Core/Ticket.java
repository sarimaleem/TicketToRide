public class Ticket {
    private int value;
    private City a;
    private City b;
    private boolean finished;
    public Ticket(City a, City b, int value) {
        this.a = a;
        this.b = b;
        this.value = value;
    }

    public boolean getFinished() {
        return finished;
    }


}
