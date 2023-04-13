/**
 * Create a Polygon abstract class to describe methods and attributes for a
 * polygon
 *
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public abstract class Polygon extends TwoDShape {

    protected int sides; // the sides of the polygon

    /**
     * Polygon constructor
     *
     * @param name   the name of the polygon
     * @param colour the colour of the polygon
     * @param sides  the number of sides the polygon has
     *
     */
    public Polygon(String name, String colour, int sides) {
        super(name, colour);

        // check if polygon sides is less than the required minimum
        if (sides < 3) {
            System.out.println("Error: Shape is not a polygon.\nA polygon must have at least 3 sides");
            System.exit(1);
        }

        this.sides = sides;
    }
}
