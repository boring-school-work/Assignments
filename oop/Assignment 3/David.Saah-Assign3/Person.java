
// import needed packages
import java.util.Random; // Needed for randomly choosing gender
import java.util.Arrays; // Needed for operations on arrays
import java.util.stream.IntStream; // Needed for working with input stream of values

/**
 * This class defines a Person class with 3 attributes.
 *
 * @author David Saah
 * @version 3.0
 * @since 2023-02-06
 *
 */
public class Person {

  // Initialise Person attributes
  private String name;
  private int age;
  private String gender;
  private String[] genderTypes = { "male", "female" };
  private static int votingAge;
  private static int drivingAge;
  private static int marriageAge;
  private final int MAX_INFANT_AGE = 2;
  private final int[] TODDLER_AGE = { 1, 3 };
  private final int[] TEEN_AGE = { 13, 19 };
  private final int MAX_CHILD_AGE = 15;
  private final int[] YOUTH_AGE = { 15, 24 };

  /**
   * Person constructor
   *
   * Sets default values to field names: name, age, gender
   * Randomly assigns gender of new object
   *
   */
  public Person() {
    // create random object
    Random random = new Random();

    // randomly select an index in genderTypes
    int option = random.nextInt(getGenderTypes().length);

    setName("No name yet");
    setAge(0);
    setGender(getGenderTypes()[option]);
  }

  /**
   * Person constructor with parameters
   *
   * Sets the field names of person object with given values
   *
   * @param name   the name of a person
   * @param age    the age of the person
   * @param gender the gender of the person, whether "male" or "female"
   *
   */
  public Person(String name, int age, String gender) {
    setPerson(name, age, gender);
  }

  /**
   * Sets the voting age of a person
   *
   * @param age the age at which a perosn is allowed to vote
   *
   */
  static void setVotingAge(int age) {
    votingAge = age;
  }

  /**
   * Gets the voting age
   *
   * @return the voting age
   *
   */
  static int getVotingAge() {
    return votingAge;
  }

  /**
   * Checks whether a person can vote
   *
   * @return whether a person can or cannot vote
   *
   */
  public boolean canVote() {
    return getAge() >= getVotingAge();
  }

  /**
   * Sets the minimum driving age of a person
   *
   * @param age the age at which a perosn is allowed to drive
   *
   */
  static void setDrivingAge(int age) {
    drivingAge = age;
  }

  /**
   * Gets the driving age
   *
   * @return the driving age
   *
   */
  static int getDrivingAge() {
    return drivingAge;
  }

  /**
   * Checks whether a person can drive
   *
   * @return whether a person can or cannot drive
   *
   */
  public boolean canDrive() {
    return getAge() >= getDrivingAge();
  }

  /**
   * Sets the minimum age a person can get married
   *
   * @param age the age at which a perosn is allowed to marry
   *
   */
  static void setMarriageAge(int age) {
    marriageAge = age;
  }

  /**
   * Gets the minimum marriage age
   *
   * @return the marriage age
   *
   */
  static int getMarriageAge() {
    return marriageAge;
  }

  /**
   * Checks whether a person can marry
   *
   * @return whether a person can or cannot marry
   *
   */
  public boolean canMarry() {
    return getAge() >= getMarriageAge();
  }

  /**
   * Checks whether a person is an adult
   * An adult is a person who can vote, drive and get married
   *
   * @return whether or not a person is an adult
   *
   */
  public boolean isAdult() {
    return (canDrive() && canVote() && canMarry());
  }

  /**
   * Creates an adult person
   * An adult satifies all the age criteria:
   * - Must be able to vote, drive, and marry
   *
   * @param name   the name of the adult
   * @param gender the gender of the adult
   *
   * @return a person object representing an adult
   *
   */
  static Person createAdult(String name, String gender) {
    // Create new person
    Person person = new Person();
    person.setName(name);
    person.setGender(gender);

    // Store valid adult ages in an array
    int age[] = { getVotingAge(), getMarriageAge(), getDrivingAge() };

    // Use `max()` method from IntStream to get the maximum age
    int adultAge = IntStream.of(age).max().getAsInt();

    // set new adult age as person's age
    person.setAge(adultAge);

    return person;
  }

  /**
   * Checks if a person is an infant
   *
   * @return whether or not a person is an infant
   *
   */
  public boolean isInfant() {
    return getAge() < MAX_INFANT_AGE;
  }

  /**
   * Checks if a person is a toddler
   *
   * @return whether or not a person is a toddler
   *
   */
  public boolean isToddler() {
    return (getAge() >= TODDLER_AGE[0]) && (getAge() <= TODDLER_AGE[1]);
  }

  /**
   * Checks if a person is a child
   *
   * @return whether or not a person is a child
   *
   */
  public boolean isChild() {
    return getAge() < MAX_CHILD_AGE;
  }

  /**
   * Checks if a person is a teenager
   *
   * @return whether or not a person is a teenager
   *
   */
  public boolean isTeenager() {
    return (getAge() >= TEEN_AGE[0]) && (getAge() <= TEEN_AGE[1]);
  }

  /**
   * Checks if a person is a youth
   *
   * @return whether or not a person is a youth
   *
   */
  public boolean isYouth() {
    return (getAge() >= YOUTH_AGE[0]) && (getAge() <= YOUTH_AGE[1]);
  }

  /**
   * Gets the genderTypes array
   *
   * @return a list of gender types
   *
   */
  public String[] getGenderTypes() {
    return this.genderTypes;
  }

  /**
   * Gets the name of the person
   *
   * @return the name of the person
   *
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the age of the person
   *
   * @return the age of the person
   *
   */
  public int getAge() {
    return age;
  }

  /**
   * Gets the gender of the person
   *
   * @return the gender of the person
   *
   */
  public String getGender() {
    return gender;
  }

  /**
   * Sets the name of the person
   *
   * @param name the name of a person
   *
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the age of the person if the value chosen is not negative.
   * Displays an error message if the age chosen is negative.
   * Exits the program after displaying an error message.
   *
   * @param age the age chosen
   *
   */
  public void setAge(int age) {
    if (age >= 0) {
      this.age = age;
    } else {
      System.out.println("Error: The age entered is negative!");
      System.exit(0);
    }
  }

  /**
   * Sets the gender of the person.
   * For simplicity, valid values for gender are "male" and "female".
   * It checks if an invalid value for gender is given.
   * Displays an error message if the chosen gender is invalid.
   * Exits the program after displaying an error message.
   *
   * @param gender the gender of a person, whether "male" or "female"
   *
   */
  public void setGender(String gender) {
    // Check if gender entered is valid
    boolean isValidGender = Arrays.stream(getGenderTypes())
        .anyMatch(gender::equalsIgnoreCase);

    if (isValidGender) {
      this.gender = gender;
    } else {
      System.out.println("Error: The gender status is not found in our database!");
      System.exit(0);
    }
  }

  /**
   * Sets all the attributes of a person: name, age and gender.
   *
   * @param name   the name of the person
   * @param age    the age of the person
   * @param gender the gender of the person, whether "male" or "female"
   *
   */
  public void setPerson(String name, int age, String gender) {
    setName(name);
    setAge(age);
    setGender(gender);
  }

  /**
   * Checks if two person objects have the same name
   *
   * @param otherPerson another person object
   *
   * @return whether the two person objects have the same name
   *
   */
  public boolean isSameName(Person otherPerson) {
    return getName().equals(otherPerson.getName());
  }

  /**
   * Checks if two person objects have the same age
   *
   * @param otherPerson another person object
   *
   * @return whether the two person objects have the same age
   *
   */
  public boolean isSameAge(Person otherPerson) {
    return getAge() == otherPerson.getAge();
  }

  /**
   * Checks if two person objects are equal
   * i.e. they have the same name and age
   *
   * @param otherPerson another person object
   *
   * @return whether the person objects are equal or not
   *
   */
  public boolean equals(Person otherPerson) {
    return isSameName(otherPerson) && isSameAge(otherPerson);
  }

  /**
   * Checks if a person object is older than the other
   *
   * @param otherPerson another person object
   * @return whether a person is older than the other
   */
  public boolean isOlder(Person otherPerson) {
    return getAge() > otherPerson.getAge();
  }

  /**
   * Checks if a person object is younger than the other
   *
   * @param otherPerson another person object
   * @return whether a person is younger than the other
   */
  public boolean isYounger(Person otherPerson) {
    return !isOlder(otherPerson);
  }
}
