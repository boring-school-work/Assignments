
// import libraries
import java.util.Arrays;

/**
 * A class that represents a bus that holds a given number of people.
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-03-24
 * 
 */
public class Bus {
    // define instance variables
    private int capacity; // the number of passengers a bus can take (excludes the driver)
    private String licensePlateNum; // the bus license plate number
    private String make; // the bus make
    private String model; // the bus model
    private String colour; // the colour of the bus
    private Person driver; // the driver of the bus
    private Person[] passengers; // an array representing the passengers inside the bus
    private int passengerCount = 0; // set a counter to track the number of passengers in the bus

    /**
     * Default constructor
     * 
     * @param capacity the maximum number of passengers a bus can take
     * 
     */
    public Bus(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Constructor that sets more parameters for the bus
     * 
     * @param capacity        the maximum number of passengers a bus can take
     * @param licensePlateNum the bus licence plate number
     * @param make            the make of the bus
     * @param model           the model of the bus
     * @param colour          the colour of the bus
     * 
     */
    public Bus(int capacity, String licensePlateNum, String make, String model, String colour) {
        this.capacity = capacity;
        this.licensePlateNum = licensePlateNum;
        this.make = make;
        this.model = model;
        this.colour = colour;
        driver = null;

        // set the size of passenger array to bus capacity
        passengers = new Person[capacity];
    }

    /**
     * Gets the bus capacity
     * 
     * @return the bus capacity
     * 
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the bus license plate number
     * 
     * @return the bus license plate number
     * 
     */
    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    /**
     * Gets the make of the bus
     * 
     * @return the make of the bus
     * 
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the bus model
     * 
     * @return the model of the bus
     * 
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the colour of the bus
     * 
     * @return the colour of the bus
     * 
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the driver of the bus
     * 
     * @param person a potential driver
     * @return whether or not setting the bus driver was successful
     * 
     */
    public boolean setDriver(Person person) {
        if (person.canDrive()) {
            driver = person;
            return true;
        }

        return false;
    }

    /**
     * Checks if the bus has a driver
     * 
     * @return whether or not the bus has a driver
     * 
     */
    public boolean hasDriver() {
        return driver != null;
    }

    /**
     * Adds a passenger to the bus if there is an empty seat
     * Increases the number of passengers by 1 if successful
     * 
     * @param person a new passenger
     * @return whether or not the addition of a new passenger was successful
     * 
     */
    public boolean addPassenger(Person person) {
        for (int index = 0; index < passengers.length; index++) {
            // check if there is an empty seat available
            // assign the new passenger to that seat
            if (passengers[index] == null) {
                passengers[index] = person;
                passengerCount++;
                return true;
            }
        }

        return false;
    }

    /**
     * Removes a passenger from the bus
     * Reduces the number of passengers by 1 if successful
     * 
     * @param person an existing passenger
     * @return whether or not the removal of a passenger was successful
     * 
     */
    public boolean removePassenger(Person person) {
        for (int index = 0; index < passengers.length; index++) {
            // check if the passenger exists in the bus
            if ((passengers[index] != null) && person.equals(passengers[index])) {
                // remove the passenger by assigning the passenger value to null
                passengers[index] = null;
                passengerCount--;
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the number of passengers on the bus
     * 
     * @return the number of passengers
     * 
     */
    public int getNumPassengers() {
        return passengerCount;
    }

    /**
     * Gets the number of occupants in the bus including the driver
     * 
     * @return the number of occupants in the bus
     * 
     */
    public int getNumOccupants() {
        // If there is a driver, the number of occupants = total passengers + 1
        // else the occupants are just the number of passengers
        return hasDriver() ? getNumPassengers() + 1 : getNumPassengers();
    }

    /**
     * Checks if there are passengers on the bus
     * 
     * @return whether or not there are passengers on the bus
     * 
     */
    public boolean hasPassengers() {
        return Arrays.stream(passengers).anyMatch(person -> person != null);
    }

    /**
     * Checks if the bus is empty
     * 
     * @return whether or not the bus is empty
     * 
     */
    public boolean isEmpty() {
        return getNumOccupants() == 0;
    }

    /**
     * Checks whether the bus is full
     * 
     * @return whether or not the bus is full
     * 
     */
    public boolean isFull() {
        // the number of occupants includes the driver
        // Adding 1 to the bus capacity caters for that deficit
        return getNumOccupants() == getCapacity() + 1;
    }

    /**
     * Display all the riders in the bus (passengers & driver)
     * 
     */
    public void listRiders() {
        // check if the bus is empty and display appropriate message
        if (isEmpty()) {
            System.out.println("There are no riders in this bus");
            return;
        }

        System.out.println("List of riders in the bus\n");

        // Display driver details if there is a driver
        if (hasDriver()) {
            System.out.println("Driver Details");
            System.out.printf("Name: %s\nGender: %s\nAge: %d\n\n",
                    driver.getName(), driver.getGender(), driver.getAge());
        }

        // Display passenger details if there are passengers
        if (hasPassengers()) {
            System.out.println("Passengers' Details");

            for (Person passenger : passengers) {
                if (passenger != null) {
                    System.out.printf("Name: %s\nGender: %s\nAge: %d\n\n",
                            passenger.getName(), passenger.getGender(), passenger.getAge());
                }
            }
        }
    }

    /**
     * Gets the position of empty seats in the bus
     * 
     * @return an array representing the position of empty seats in the bus
     * 
     */
    public int[] getEmptySeats() {
        int[] emptySeats = new int[getCapacity()];
        int item = 0; // a counter to track the index in the emptySeats array
        for (int index = 0; index < passengers.length; index++) {
            if (passengers[index] == null) {
                emptySeats[item] = index;
                item++; // increase the index counter by 1 each successful addition
            }
        }

        return emptySeats;
    }
}
