/**
 * ThreeDShape is an abstract class that extends Shape.
 *
 * @author Ian Joseph
 * @author David Saah
 * @version 2.0
 * @since 2023-03-31
 *
 */
public abstract class ThreeDShape extends Shape {

    /**
     * ThreeDShape constructor
     *
     */
    public ThreeDShape(String name, String colour) {
        super(name, colour, true);
    }

    /**
     * Computes the volume of the 3D shape
     *
     * @return the volume of the shape
     *
     */
    public abstract double computeVolume();

    /**
     * Computes the surface area of the 3D shape
     *
     * @return the surface area of the shape
     *
     */
    public abstract double computeSurfaceArea();

}