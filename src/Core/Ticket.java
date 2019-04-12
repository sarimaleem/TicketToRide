public class Ticket {
    private int value;
    private String a;
    private String b;
    private boolean finished;
    public Ticket(String a, String b, int value) {
        this.a = a;
        this.b = b;
        this.value = value;
        this.finished = false;
    }
    public String getA(){
        return a;
    }
    public String getB(){
        return b;
    }
    public int getValue(){
        return value;
    }
    public boolean getFinished() {
        return finished;
    }
    public String toString(){
        return a+" "+b+" "+value;
    }

}
