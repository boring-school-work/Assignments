/**
 * Create a Shape abstract class to describe methods and attributes for a shape
 * 
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public abstract class Shape {
    protected String name; // the name of the shape
    protected String colour; // the colour of the shape
    protected boolean is3D; // false if 2D and true if 3D

    /**
     * Shape constructor
     *
     * @param name   the name of the shape
     * @param colour the colour of the shape
     * @param is3D   whether the shape is 2D or 3D
     *
     */
    public Shape(String name, String colour, boolean is3D) {
        this.name = name;
        this.colour = colour;
        this.is3D = is3D;
    }

    /**
     * Gets the name of the shape
     *
     * @return the name of the shape
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the colour of the shape
     *
     * @return the colour of the shape
     *
     */
    public String getColour() {
        return colour;
    }

    /**
     * Gets the value of is3D
     *
     * @return whether the shape is 2D or 3D
     *
     */
    public boolean isThreeDimensional() {
        return is3D;
    }

    /**
     * An abstract class for getting the description of a shape
     *
     * @return the description of the shape
     *
     */
    public abstract String getDescription();
}
