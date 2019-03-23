public class SampleCoreClass {
    //This class is just a simple rectangle
    private String color;


    public SampleCoreClass(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void switchColor() {
        if (color.equals("green"))
            color = "blue";
        else
            color = "green";
    }
}
