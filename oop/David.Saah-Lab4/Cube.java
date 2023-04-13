/**
 * A program that implements a Cube class
 *
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public class Cube extends ThreeDShape {
    private double length; // the length of a side of the cube

    /**
     * Cube constructor
     *
     * @param colour the colour of the cube
     * @param length the length of side
     *
     */
    public Cube(String colour, double length) {
        super("Cube", colour);
        this.length = length;
    }

    /**
     * Computes the volume of the cube
     *
     * @return the volume of the cube
     *
     */
    public double computeVolume() {
        return length * length * length;
    }

    /**
     * Computes the surface area of a cube
     *
     * @return the surface area of a cube
     *
     */
    public double computeSurfaceArea() {
        return 6 * length * length;
    }

    /**
     * Gives a detailed description of the shape
     *
     * @return description of the cube object
     *
     */
    public String getDescription() {
        return ("A" + " " + getColour() + " " + getName()
                + " with side length = " + length + " cm.");
    }

    public static void main(String[] args) {
        Cube cube = new Cube("red", 5);
        System.out.println(cube.getDescription());
        System.out.println("Volume: " + cube.computeVolume());
        System.out.println("Surface Area: " + cube.computeSurfaceArea());
    }
}
