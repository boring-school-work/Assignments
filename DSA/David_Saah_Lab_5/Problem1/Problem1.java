/**
 * Problem1
 */
public class Problem1 {

  public static void main(String[] args) {
    HashTable table = new HashTable();

    try {
      // display table size and capacity
      System.out.println("-".repeat(25));
      System.out.printf("Initial size: %d\n", table.getSize());
      System.out.printf("Initial capacity: %d\n", table.getCapacity());
      System.out.println("-".repeat(25));

      /* INSERT DATA */
      System.out.println();
      System.out.println("Adding entries...");
      System.out.println("-".repeat(25));
      table.insert("Kojo", 1.0);
      table.insert("Kofi", 2.0);
      table.insert("Kwame", 3.0);
      table.insert("Kwesi", 4.0);
      table.insert("Kwabena", 6.0);
      table.insert("Kwaku", 7.0);
      table.insert("Yaw", 8.0);
      table.insert("Esi", 9.0);
      table.insert("Akosua", 10.0);
      table.insert("Adwoa", 11.0);

      // display table size and capacity
      System.out.println();
      System.out.println("-".repeat(25));
      System.out.printf("Size: %d\n", table.getSize());
      System.out.printf("Capacity: %d\n", table.getCapacity());
      System.out.println("-".repeat(25));

      /* TEST TABLE RESIZE */
      System.out.println();
      System.out.println("Adding new entries to resize table...");
      System.out.println("-".repeat(25));
      table.insert("Ama", 12.0);
      table.insert("Yaa", 13.0);
      table.insert("Afua", 14.0);
      table.insert("Aba", 15.0);
      table.insert("Akua", 16.0);
      table.insert("Yawa", 17.0);
      table.insert("Awo", 18.0);

      // display table size and capacity
      System.out.println();
      System.out.println("-".repeat(25));
      System.out.printf("Size: %d\n", table.getSize());
      System.out.printf("Capacity: %d\n", table.getCapacity());
      System.out.println("-".repeat(25));

      /* TEST UPDATE ENTRIES */
      System.out.println();
      System.out.println("Updating 5 entries...");
      System.out.println("-".repeat(25));
      table.insert("Kojo", 1.5);
      table.insert("Kofi", 2.5);
      table.insert("Kwame", 3.5);
      table.insert("Kwesi", 4.5);
      table.insert("Kwabena", 6.5);

      // display table
      System.out.println();
      System.out.println("Displaying table...");
      System.out.println("-".repeat(25));
      table.display();

      /* TEST TABLE SEARCH */
      System.out.println();
      System.out.println("Searching for entries...");
      System.out.println("-".repeat(25));
      System.out.printf("Kojo: %.2f\n", table.search("Kojo"));
      System.out.printf("Kofi: %.2f\n", table.search("Kofi"));
      System.out.printf("Kwame: %.2f\n", table.search("Kwame"));
      System.out.printf("Kwesi: %.2f\n", table.search("Kwesi"));

      /* TEST ENTRY DELETION */
      System.out.println();
      System.out.println("Deleting entries...");
      System.out.println("-".repeat(25));
      table.delete("Kojo");
      table.delete("Kofi");
      table.delete("Kwame");
      table.delete("Kwesi");
      table.delete("Kwabena");

      // display table
      System.out.println();
      System.out.println("Displaying table...");
      System.out.println("-".repeat(25));
      table.display();

      /* ADD MORE ENTRIES TO CHECK IF COLLISIONS ARE AVOIDED */
      // adding 10 more entries
      System.out.println();
      System.out.println("Adding 10 more entries...");
      System.out.println("-".repeat(25));
      table.insert("Mary", 19.0);
      table.insert("John", 20.0);
      table.insert("Jane", 21.0);
      table.insert("Mark", 22.0);
      table.insert("Luke", 23.0);
      table.insert("Matthew", 24.0);
      table.insert("James", 25.0);
      table.insert("Peter", 26.0);
      table.insert("Paul", 27.0);
      table.insert("Jude", 28.0);

      // display table size and capacity
      System.out.println();
      System.out.println("-".repeat(25));
      System.out.printf("Size: %d\n", table.getSize());
      System.out.printf("Capacity: %d\n", table.getCapacity());
      System.out.println("-".repeat(25));

      // display table
      System.out.println();
      System.out.println("Displaying table...");
      System.out.println("-".repeat(25));
      table.display();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
