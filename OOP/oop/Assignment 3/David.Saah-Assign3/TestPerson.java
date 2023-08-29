/**
 * This program tests the Person class.
 *
 * @author David Saah
 * @version 3.0
 * @since 2023-02-06
 *
 */
public class TestPerson {

    /**
     * Checks if the person objects are equal
     *
     * @param self  main person object
     * @param other other person object
     *
     */
    public static void testEquals(Person self, Person other) {
        if (self.equals(other)) {
            System.out.println("The person objects are equal\n");
        } else {
            System.out.println("The person objects are not equal\n");
        }
    }

    /**
     * Checks to see if a person is younger than the other
     *
     * @param self  main person object
     * @param other other person object
     *
     */
    public static void testYoungerPerson(Person self, Person other) {
        if (self.isYounger(other)) {
            System.out.printf("%s is younger than %s\n\n",
                    self.getName(), other.getName());
        } else {
            System.out.printf("%s is not younger than %s\n\n",
                    self.getName(), other.getName());
        }
    }

    /**
     * Checks to see if a person is older than the other
     *
     * @param self  main person object
     * @param other other person object
     *
     */
    public static void testOlderPerson(Person self, Person other) {
        if (self.isOlder(other)) {
            System.out.printf("%s is older than %s\n\n",
                    self.getName(), other.getName());
        } else {
            System.out.printf("%s is not older than %s\n\n",
                    self.getName(), other.getName());
        }
    }

    /**
     * Checks whether two person objects have the same name
     *
     * @param self  main person object
     * @param other other person object
     *
     */
    public static void testSameName(Person self, Person other) {
        if (self.isSameName(other)) {
            System.out.println("The person objects have the same name\n");
        } else {
            System.out.println("The person objects do not have the same name\n");
        }
    }

    /**
     * Checks whether two person objects have the same age
     *
     * @param self  main person object
     * @param other other person object
     *
     */
    public static void testSameAge(Person self, Person other) {
        if (self.isSameAge(other)) {
            System.out.println("The person objects have the same age\n");
        } else {
            System.out.println("The person objects do not have the same age\n");
        }
    }

    /**
     * Checks whether a person can vote
     *
     * @param person a person object
     *
     */
    public static void testCanVote(Person person) {
        if (person.canVote()) {
            System.out.printf("%s can vote\n\n", person.getName());
        } else {
            System.out.printf("%s cannot vote\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person can drive
     *
     * @param person a person object
     *
     */
    public static void testCanDrive(Person person) {
        if (person.canDrive()) {
            System.out.printf("%s can drive\n\n", person.getName());
        } else {
            System.out.printf("%s cannot drive\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person can get married
     *
     * @param person a person object
     *
     */
    public static void testCanMarry(Person person) {
        if (person.canMarry()) {
            System.out.printf("%s can marry\n\n", person.getName());
        } else {
            System.out.printf("%s cannot marry\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person is an adult
     *
     * @param person a person object
     *
     */
    public static void testIsAdult(Person person) {
        if (person.isAdult()) {
            System.out.printf("%s is an adult\n\n", person.getName());
        } else {
            System.out.printf("%s is not an adult\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person is an infant
     *
     * @param person a person object
     *
     */
    public static void testIsInfant(Person person) {
        if (person.isInfant()) {
            System.out.printf("%s is an infant\n\n", person.getName());
        } else {
            System.out.printf("%s is not an infant\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person is a toddler
     *
     * @param person a person object
     *
     */
    public static void testIsToddler(Person person) {
        if (person.isToddler()) {
            System.out.printf("%s is a toddler\n\n", person.getName());
        } else {
            System.out.printf("%s is not a toddler\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person is a child
     *
     * @param person a person object
     *
     */
    public static void testIsChild(Person person) {
        if (person.isChild()) {
            System.out.printf("%s is a child\n\n", person.getName());
        } else {
            System.out.printf("%s is not a child\n\n", person.getName());
        }
    }

    /**
     * Checks whether a person is a teenager
     *
     * @param person a person object
     *
     */
    public static void testIsTeenager(Person person) {
        if (person.isTeenager()) {
            System.out.printf("%s is a teenager\n\n", person.getName());
        } else {
            System.out.printf("%s is not a teenager\n\n", person.getName());
        }
    }

    /**
     * Gets all the information about a person
     *
     * @param person a person object
     *
     */
    public static void getPersonInfo(Person person) {
        testCanVote(person);
        testCanDrive(person);
        testCanMarry(person);
        testIsInfant(person);
        testIsChild(person);
        testIsTeenager(person);
        testIsYouth(person);
        testIsAdult(person);
    }

    /**
     * Checks whether a person is a youth
     *
     * @param person a person object
     *
     */
    public static void testIsYouth(Person person) {
        if (person.isYouth()) {
            System.out.printf("%s is a youth\n\n", person.getName());
        } else {
            System.out.printf("%s is not a youth\n\n", person.getName());
        }
    }

    /**
     * The main method runs the tests
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        // Create a Person object and define parameters using setPerson method
        Person person1 = new Person();
        person1.setPerson("David Saah", 20, "male");

        // Display the attributes of person1 object
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                person1.getName(), person1.getAge(), person1.getGender());

        // Create a Person object to use the default values of the class constructor
        Person person2 = new Person();

        // Display the attributes of person2 object
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                person2.getName(), person2.getAge(), person2.getGender());

        // Create a Person object and set field values using constructor
        Person person3 = new Person("Ada Lovelace", 43, "female");

        // Display the attributes of person3 object
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                person3.getName(), person3.getAge(), person3.getGender());

        // clone person3
        Person person3Clone = person3;

        /*
         * Testing the properties of objects.
         * Case 1: Objects are equal (same name and age).
         * Case 2: One person is older than the other.
         * Case 3: One person is younger than the other.
         * Case 4: Objects have the same name.
         * Case 5: Objects have the same age.
         *
         */

        // Case 1: Objects are not equal
        testEquals(person1, person3);

        // Case 1: Objects are equal
        testEquals(person3, person3Clone);

        // Case 2: First person is older
        testOlderPerson(person3, person1);

        // Case 2: First person is not older
        testOlderPerson(person1, person3);

        // Case 3: First person is younger
        testYoungerPerson(person1, person3);

        // Case 3: First person is not younger
        testYoungerPerson(person3, person1);

        // Case 4: Objects have the same name
        testSameName(person3, person3Clone);

        // Case 4: Objects do not have the same name
        testSameName(person1, person3);

        // Case 5: Objects have the same age
        testSameAge(person3, person3Clone);

        // Case 5: Objects do not have the same age
        testSameAge(person2, person3);

        // Create new person objects
        Person child = new Person("Nana", 14, "male");
        Person infant = new Person("Naa", 1, "female");
        Person toddler = new Person("Yaa", 2, "female");
        Person teenager = new Person("Bright", 17, "male");

        // Display the attributes of child
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                child.getName(), child.getAge(), child.getGender());

        // Display the attributes of infant
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                infant.getName(), infant.getAge(), infant.getGender());

        // Display the attributes of toddler
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                toddler.getName(), toddler.getAge(), toddler.getGender());

        // Display the attributes of toddler
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                teenager.getName(), teenager.getAge(), teenager.getGender());

        // Setting minimum age for persons in relation to different categories
        Person.setVotingAge(18);
        Person.setDrivingAge(16);
        Person.setMarriageAge(24);

        // Create an adult person
        Person adult = Person.createAdult("Jeremy", "male");

        /*
         * Testing more person methods
         * Case 6: A person can drive
         * Case 7: A person can vote
         * Case 8: A person can marry
         * Case 9: A person is an adult
         * Case 10: A person is an infant
         * Case 11: A person is a toddler
         * Case 12: A person is a child
         * Case 13: A person is a teenager
         * Case 14: A person is a youth
         * Case 15: Test Cases 6 - 14
         *
         */

        // Case 6: A person can drive
        testCanDrive(adult);

        // Case 6: A person cannot drive
        testCanDrive(child);

        // Case 7: A person can vote
        testCanVote(person1);

        // Case 7: A person cannot vote
        testCanVote(toddler);

        // Case 8: A person can marry
        testCanMarry(person3);

        // Case 8: A person cannot marry
        testCanMarry(teenager);

        // Case 9: A person is an adult
        testIsAdult(adult);

        // Case 9: A person is not an adult
        testIsAdult(infant);

        // Case 10: A person is an infant
        testIsInfant(infant);

        // Case 10: A person is not an infant
        testIsInfant(person1);

        // Case 11: A person is a toddler
        testIsToddler(toddler);

        // Case 11: A person is not a toddler
        testIsToddler(person3);

        // Case 12: A person is a child
        testIsChild(child);

        // Case 12: A person is not a child
        testIsChild(adult);

        // Case 13: A person is a teenager
        testIsTeenager(teenager);

        // Case 13: A person is not a teenager
        testIsTeenager(person3);

        // Case 14: A person is a youth
        testIsYouth(person1);

        // Case 14: A person is not a youth
        testIsYouth(person3);

        // Case 15: Test Cases 6 - 14
        getPersonInfo(person1);

        /*
         * Testing object initialisation cases where program exists
         * Case 1: Invalid age
         * Case 2: Invalid gender
         *
         */

        // Create a Person object with an invalid age
        Person person5 = new Person();
        person5.setPerson("Dr. John Edem", -18, "male");

        // Display the attributes of person5 object
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                person5.getName(), person5.getAge(), person5.getGender());

        /*
         * NOTE: To see the effect of person6 object,
         * comment out the person5 object's initialisation and operations.
         *
         * REASON: The program exits if an invalid age is entered.
         *
         */

        // Create a Person object with an invalid gender
        Person person6 = new Person();
        person6.setPerson("John Doe", 67, "Deceased");

        // Display the attributes of person6 object
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n\n",
                person6.getName(), person6.getAge(), person6.getGender());
    }
}
