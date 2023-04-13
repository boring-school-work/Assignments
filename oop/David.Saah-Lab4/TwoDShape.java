/**
 * Create a TwoDShape abstract class that inherits from the Shape class
 *
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public abstract class TwoDShape extends Shape {

    /**
     * TwoDShape constructor
     *
     * Assigns the values for the name of the shape and its colour.
     * It sets is3D attribute to false.
     *
     * @param name   the name of the shape
     * @param colour the colour of the shape
     *
     */
    public TwoDShape(String name, String colour) {
        super(name, colour, false);
    }

    /**
     * An abstract class to compute the area of the shape
     *
     * @return the area of the shape
     *
     */
    public abstract double computeArea();

    /**
     * An abstract class to compute the perimeter of a shapea
     *
     * @return the perimeter of the shape
     *
     */
    public abstract double computePerimeter();

    /**
     * An abstract method that describes how to draw a shape
     *
     */
    public abstract void draw();
}
