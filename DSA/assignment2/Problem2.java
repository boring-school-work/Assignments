import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Building a Generic Data Storage System
 *
 * @author David Saah
 * @since 2023-09-13
 * @version 1.0
 */
public class Problem2 {
  public static void main(String[] args) {
    // create data entries
    DataEntry<String> name = new DataEntry<>("name", "David Saah");
    DataEntry<Integer> age = new DataEntry<>("age", 21);
    DataEntry<String[]> links = new DataEntry<>("links", new String[] {
        "github.com/DaveSaah", "davesaah.hasnode.dev"
    });
    DataEntry<String> school = new DataEntry<>("sch", "Ashesi");

    // create data storage
    DataStorage<DataEntry<?>> daveStore = new DataStorage<>();

    /* Test 1 -> Add entries to data storage */
    daveStore.addEntry(name);
    daveStore.addEntry(age);
    daveStore.addEntry(links);
    daveStore.addEntry(school);

    /* Test 2 -> Show the total number of entries */
    System.out.printf("There are %d entries in dave's store.\n", daveStore.getEntryCount());
    System.out.println();

    /* Test 3 -> Show all the entries in the data storage */
    daveStore.listAllEntries();
    System.out.println();

    try {
      /* Test 4 -> retrieve entry from data storage */
      System.out.printf("%s attends %s.\nHe is %d years.\n",
          daveStore.retrieveEntry("name").getData(),
          daveStore.retrieveEntry("sch").getData(),
          daveStore.retrieveEntry("age").getData());
      System.out.println();

      /* Test 5 -> get average timestamp of data entries */
      System.out.printf("The average timestamp of the data entries are: %d.\n", daveStore.getAverageTimestamp());
      System.out.println();

      /* Test 6 -> get info from the latest data entry */
      System.out.printf("The latest entry (identifier) is: %s.\nIt was added at: %s\n",
          daveStore.getLatestEntry().getIdentifier(), daveStore.getLatestEntry().getTimestampDate());
      System.out.println();

      /* Test 7 -> remove a data entry */
      daveStore.removeEntry("links");
      System.out.println();

      System.out.println("After removing the links entry, the entries are: ");
      System.out.println();
      daveStore.listAllEntries();
      System.out.println();

    } catch (Exception e) {
      // catch any errors that may occur
      System.out.println(e.getMessage());
      System.exit(1);
    }

  }
}

/**
 * DataEntry class
 *
 * A generic class that allows the definition of a data entry
 *
 * @param T the type of data to be stored
 */
class DataEntry<T> {
  private String identifier; // the identifier of the data
  private T data; // a data value of any type
  private long timestamp; // represents the time of entry

  DataEntry(String identifier, T data) {
    Date date = new Date(); // create a date object to get the current time

    this.identifier = identifier;
    this.data = data;
    this.timestamp = new Timestamp(date.getTime()).getTime(); // get the current time in long format
  }

  /***
   * Gets the unique identifier of the data entry
   *
   * @return the unique identifier of the data entry
   */
  String getIdentifier() {
    return identifier;
  }

  /**
   * Gets the data stored in the data entry
   *
   * @return the data stored in the data entry
   */
  T getData() {
    return data;
  }

  /**
   * Gets the timestamp of the data entry
   *
   * @return the time of the data entry
   */
  long getTimestamp() {
    return timestamp;
  }

  /**
   * Gets the timestamp of the data entry in date format
   *
   * @return the time of the data entry in date format
   */
  Timestamp getTimestampDate() {
    return new Timestamp(getTimestamp());
  }
}

/**
 * DataStorage class
 *
 * A generic class that stores data entries
 *
 * @param T a type of data entry
 */
class DataStorage<T extends DataEntry<?>> {
  ArrayList<T> entries = new ArrayList<>();

  /**
   * Adds a data entry to the data storage
   *
   * @param entry the data entry to add
   */
  void addEntry(T entry) {
    entries.add(entry);
  }

  /**
   * Retrieves a data entry from the data storage
   *
   * @param identifier the identifier of the data entry to retrieve
   * @return the data entry
   * @throws Exception if the data entry does not exist
   */
  T retrieveEntry(String identifier) throws Exception {
    for (T e : entries) {
      if (e.getIdentifier().equalsIgnoreCase(identifier)) {
        return e;
      }
    }

    throw new Exception("The specified entry does not exist");
  }

  /**
   * Gets the number of entries in the data storage
   *
   * @return the number of entries in the data storage
   */
  int getEntryCount() {
    return entries.size();
  }

  /**
   * Gets the average timestamp of the data entries
   *
   * @return the average timestamp of the data entries
   * @throws Exception if there are no entries in the data storage
   */
  long getAverageTimestamp() throws Exception {
    if (entries.isEmpty()) {
      throw new Exception("ERROR: Cannot get the average timestamp");
    }

    long totalTime = 0;

    for (T e : entries) {
      totalTime += e.getTimestamp();
    }

    return totalTime / getEntryCount();
  }

  /**
   * Removes a data entry from the data storage
   *
   * @param identifier the identifier of the data entry to remove
   * @throws Exception if the data entry does not exist
   */
  void removeEntry(String identifier) throws Exception {
    entries.remove(retrieveEntry(identifier));
  }

  /**
   * Displays all the data entries in the data storage
   */
  void listAllEntries() {
    System.out.println("OUTPUT FORMAT: Identifier, Data, Timestamp, Date");
    System.out.println("-".repeat(60));

    for (T e : entries) {
      System.out.println(
          e.getIdentifier() + ", " + e.getData() + ", " + e.getTimestamp() + ", "
              + e.getTimestampDate());
    }
  }

  /**
   * Gets the latest data entry in the data storage
   *
   * @return the latest data entry in the data storage
   */
  T getLatestEntry() {
    return entries.get(getEntryCount() - 1);
  }
}
