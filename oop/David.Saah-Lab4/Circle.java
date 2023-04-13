import java.lang.Math;

/**
 * A Program that implements a Cicrle class and draws circle shapes
 *
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public class Circle extends TwoDShape {
    private double radius; // the radius of the circle

    /**
     * Circle constructor
     *
     * @param colour the colour of the circle
     * @param radius the radius of the circle
     *
     */
    public Circle(String colour, double radius) {
        super("Circle", colour);
        this.radius = radius;
    }

    /**
     * Gets the description of the shape
     *
     * @return features of the circle object
     *
     */
    public String getDescription() {
        return (getColour() + " " + getName()
                + " with radius = " + radius + "cm.");
    }

    /**
     * Computes the area of a circle
     *
     * @return the area of the circle
     *
     */
    public double computeArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Computes the perimeter of a circle
     *
     * @return the perimeter of a circle
     *
     */
    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Draws a cicle
     *
     */
    public void draw() {
        int yMax, xMax, yMin, xMin, r;
        yMax = xMax = 5;
        yMin = xMin = -5;

        // yMax - yMin = diameter of circle
        r = (yMax - yMin) / 2;

        // assign colour details to text1
        String text1 = getColour() + " " + getName();

        // assign radius details to text2
        String text2 = "r = " + radius + "cm ";

        for (int y = yMax; y >= yMin; y--) {
            for (int x = xMin; x <= xMax; x++) {
                if ((int) Math.sqrt(x * x + y * y) == r) {
                    // draw perimeter of circle
                    System.out.print("* ");
                } else if (y == 1 && x == -text1.length() / 4) {
                    // print the description of the circle
                    System.out.print(text1);
                    x += text1.length() / 2 - 1;
                } else if (y == 0 && x == -text2.length() / 4) {
                    // print the radius
                    System.out.print(text2);
                    x += text2.length() / 2 - 1;
                } else {
                    // print whitespace
                    System.out.print("  ");
                }
            }

            // add new line
            System.out.println();
        }
    }

    /* A method to test the Circle class */
    public static void main(String[] args) {
        Circle c1 = new Circle("Red", 6.7);
        Circle c2 = new Circle("Blue", 5);
        System.out.println(c1.getDescription());
        c1.draw();
        System.out.println(c2.getDescription());
        c2.draw();
    }

}
