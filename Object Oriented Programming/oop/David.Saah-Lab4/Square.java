/**
 * A program that implements a Square class and draw square shapes
 *
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public class Square extends Polygon {

    private double length; // the length of a side of the square

    /**
     * Square constructor
     *
     * @param colour the colour of the square
     * @param length the length of side
     *
     */
    public Square(String colour, double length) {
        super("Square", colour, 4);
        this.length = length;
    }

    /**
     * Computes the area of the square
     *
     * @return the area of the square
     *
     */
    public double computeArea() {
        return length * length;
    }

    /**
     * Computes the perimeter of a square
     *
     * @return the perimeter of a square
     *
     */
    public double computePerimeter() {
        return 4 * length;
    }

    /**
     * Gives a detailed description of the shape
     *
     * @return description of the square object
     *
     */
    public String getDescription() {
        return ("A" + " " + getColour() + " " + getName()
                + " with side length = " + length + " cm.");
    }

    /**
     * Draw a square shape
     *
     */
    public void draw() {
        int max = (int) length;

        System.out.println(" ".repeat(5) + "* ".repeat(max));

        for (int i = 1; i < (max - 1); i++) {
            System.out.println(" ".repeat(5) + "* " + " ".repeat((2 * max) - 4) + "* ");
        }

        System.out.println(" ".repeat(5) + "* ".repeat(max));
    }

    public static void main(String[] args) {
        // create two square objects
        Square square1 = new Square("red", 5);
        Square square2 = new Square("yellow", 10);

        // display the description of the square objects

        System.out.println();
        System.out.println(square1.getDescription());

        System.out.println();
        square1.draw();
        System.out.println();

        System.out.println("Area: " + square1.computeArea());
        System.out.println("Perimeter: " + square1.computePerimeter());
        System.out.println();

        System.out.println();
        System.out.println(square2.getDescription());
        System.out.println();
        square2.draw();
        System.out.println();

        System.out.println("Area: " + square2.computeArea());
        System.out.println("Perimeter: " + square2.computePerimeter());

    }

}
