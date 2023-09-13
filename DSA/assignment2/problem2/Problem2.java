import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

class DataEntry<T> {
  private String identifier;
  private T data;
  private long timestamp;

  DataEntry(String identifier, T data) {
    Date date = new Date(); // create a date object to get the current time

    this.identifier = identifier;
    this.data = data;
    this.timestamp = new Timestamp(date.getTime()).getTime(); // get the current time in long format
  }

  String getIdentifier() {
    return identifier;
  }

  T getData() {
    return data;
  }

  long getTimestamp() {
    return timestamp;
  }

  Timestamp getTimestampDate() {
    return new Timestamp(getTimestamp());
  }
}

class DataStorage<T extends DataEntry<?>> {
  ArrayList<T> entries = new ArrayList<>();

  void addEntry(T entry) {
    entries.add(entry);
  }

  T retrieveEntry(String identifier) throws Exception {
    for (T e : entries) {
      if (e.getIdentifier().equalsIgnoreCase(identifier)) {
        return e;
      }
    }

    throw new Exception("The specified entry does not exist");
  }

  int getEntryCount() {
    return entries.size();
  }

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

  void removeEntry(String identifier) throws Exception {
    entries.remove(retrieveEntry(identifier));
  }

  void listAllEntries() {
    System.out.println("OUTPUT FORMAT: Identifier, Data, Timestamp (long), Timestamp (date)");
    System.out.println("-".repeat(50));

    for (T e : entries) {
      System.out.println(
          e.getIdentifier() + ", " + e.getData() + ", " + e.getTimestamp() + ", "
              + e.getTimestampDate());
    }
  }

  T getLatestEntry() {
    return entries.get(getEntryCount() - 1);
  }
}

/**
 * Problem2
 */
public class Problem2 {

  public static void main(String[] args) {
    DataEntry<String> name = new DataEntry<>("name", "David Saah");
    DataEntry<Integer> age = new DataEntry<>("age", 21);
    DataEntry<String[]> links = new DataEntry<>("links", new String[] {
        "github.com/DaveSaah", "davesaah.hasnode.dev"
    });
    DataEntry<String> school = new DataEntry<>("sch", "Ashesi");

    DataStorage<DataEntry<?>> dave = new DataStorage<>();

    dave.addEntry(name);
    dave.addEntry(age);
    dave.addEntry(links);
    dave.addEntry(school);

    System.out.printf("There are %d entries in dave's Data storage", dave.getEntryCount());

    try {
      System.out.printf("%s attends %s.\nHe is %d years.\n",
          dave.retrieveEntry("name").getData(), dave.retrieveEntry("sch").getData(),
          dave.retrieveEntry("age").getData());

      System.out.printf("There are %d entries in this storage.\n", dave.getEntryCount());
      System.out.printf("The average timestamp of the data entries are: %d.\n", dave.getAverageTimestamp());

      dave.listAllEntries();
      System.out.printf("The latest entry (identifier) is: %s.\nIt was added at: %s\n",
          dave.getLatestEntry().getIdentifier(), dave.getLatestEntry().getTimestampDate());

      dave.removeEntry("links");
      dave.listAllEntries();

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

  }
}
