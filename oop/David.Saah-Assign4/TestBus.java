/**
 * A class that tests the bus class
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-03-24
 * 
 */
public class TestBus {
    /**
     * tests if a bus has a driver
     * 
     * @param bus a bus object
     * 
     */
    public static void testHasDriver(Bus bus) {
        if (bus.hasDriver()) {
            System.out.printf("%s bus has a driver.\n", bus.getMake());
        } else {
            System.out.printf("%s bus does not have a driver.\n", bus.getMake());
        }
    }

    /**
     * tests if a bus has passengers
     * 
     * @param bus a bus object
     * 
     */
    public static void testHasPassengers(Bus bus) {
        if (bus.hasPassengers()) {
            System.out.println("There are passengers on this bus.");
        } else {
            System.out.println("There are no passengers on this bus.");
        }
    }

    /**
     * tests if a bus is empty
     * 
     * @param bus a bus object
     * 
     */
    public static void testIsEmpty(Bus bus) {
        if (bus.isEmpty()) {
            System.out.printf("%s bus is empty.\n", bus.getMake());
        } else {
            System.out.printf("%s bus is not empty.\n", bus.getMake());
        }
    }

    /**
     * test if a bus is full
     * 
     * @param bus a bus object
     * 
     */
    public static void testIsFull(Bus bus) {
        if (bus.isFull()) {
            System.out.printf("%s bus is full.\n", bus.getMake());
        } else {
            System.out.printf("%s bus is not full.\n", bus.getMake());
        }
    }

    public static void main(String[] args) {
        // create a control bus
        Bus controlBus = new Bus(15);

        // create a new bus
        Bus benz = new Bus(5, "GZ-10134", "Benz", "Model S", "Twilight fog");

        // create a new driver
        Person driver = new Person("Kojo", 25, "male");

        // create passengers
        Person passenger1 = new Person("Kwabena", 15, "male");
        Person passenger2 = new Person("Adjoa", 55, "female");
        Person passenger3 = new Person("Kwame", 21, "male");
        Person passenger4 = new Person("Ama", 22, "female");
        Person passenger5 = new Person("Ada", 28, "female");

        // Display bus capacity of control bus
        System.out.printf("The capacity of control bus is %d.\n", controlBus.getCapacity());
        System.out.printf("The capacity of Benz bus is %d.\n\n", benz.getCapacity());

        // test has driver
        testHasDriver(benz);

        // add a driver to Benz
        System.out.println("Adding driver...");
        benz.setDriver(driver);

        // check if a driver is available now
        testHasDriver(benz);
        System.out.println();

        // check if bus has passengers
        testHasPassengers(benz);
        System.out.println("Adding passengers...");

        // add new passengers to benz
        benz.addPassenger(passenger1);
        benz.addPassenger(passenger2);
        benz.addPassenger(passenger3);
        benz.addPassenger(passenger4);

        // check if bus has passengers
        testHasPassengers(benz);

        // get the bus number statistics
        System.out.printf("There are %d passengers.\n", benz.getNumPassengers());
        System.out.printf("There are %d occupants in the bus.\n\n", benz.getNumOccupants());

        // check if bus is empty
        testIsEmpty(benz);

        // check if bus is full
        testIsFull(benz);

        // add a new passenger to make the bus full
        System.out.println("Adding a new passenger...");
        benz.addPassenger(passenger5);

        // check if bus is full
        testIsFull(benz);
        System.out.println();

        // list the bus riders
        benz.listRiders();

        // remove some passengers
        benz.removePassenger(passenger2);
        benz.removePassenger(passenger4);

        // list the empty seats in the Bus
        int[] emptySeats = benz.getEmptySeats();
        System.out.print("The empty seat positions are: ");

        if (emptySeats[0] != 0) {
            System.out.printf("%s ", emptySeats[0]);
        }

        for (int index = 1; index < emptySeats.length; index++) {
            if (emptySeats[index] == 0) {
                continue;
            }
            System.out.printf("%s ", emptySeats[index]);
        }
        System.out.println();
    }
}
