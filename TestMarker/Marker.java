public class Marker {
    private String inkColor;
    private byte inkLevel;
    private boolean isCapped;

    public Marker() {
    }

    public Marker(String color) {
        inkColor = color;
        this.isCapped = true;
        this.inkLevel = 100;
    }

    public Marker(String color, byte inkLevel) {
        inkColor = color;
        this.isCapped = true;
        this.inkLevel = inkLevel;
    }

    public String toString() {
        return "Marker[ Color: " + inkColor + " ]";
    }
}

/*
 * # Notes
 * If a parameter has the same name as a variable in a class, the overtaking is
 * called `data hiding`.
 */
