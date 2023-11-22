/**
 * Problem2
 *
 * @author David Saah
 * @version 1.0
 * @since 2023-11-21
 */
public class Problem2 {
  public static void main(String[] args) {
    /* CREATE NEW CONTACTS */
    Contact contact1 = new Contact("Kofi", "1234567");
    Contact contact2 = new Contact("Kwame", "3233537");
    Contact contact3 = new Contact("Kojo", "1434547");
    Contact contact4 = new Contact("Ama", "1230507");
    Contact contact5 = new Contact("Adwoa", "0034567");

    // create a Telephone Directory
    TelephoneDirectory list = new TelephoneDirectory();

    try {

      System.out.println("Inserting into the contact list...");
      System.out.println("-".repeat(35));

      /* INSERT INTO THE CONTACT LIST */
      list.Insert(contact1);
      list.Insert(contact2);
      list.Insert(contact3);
      list.Insert(contact4);
      list.Insert(contact5);

      System.out.println();

      /* DISPLAY THE PHONE DIRECTORY */
      System.out.println("Displaying phone directory...");
      System.out.println("-".repeat(35));
      list.Print();

      System.out.println();

      System.out.println("Searching for contacts...");
      System.out.println("-".repeat(35));

      /* SEARCH FOR A CONTACT */
      System.out.println("Searching for the telephone number of Kojo:");
      System.out.println(list.Search("Kojo"));
      System.out.println("Searching for the telephone number of Ama:");
      System.out.println(list.Search("Ama"));
      System.out.println("Searching for the telephone number of Kofi:");
      System.out.println(list.Search("Kofi"));

      System.out.println();

      /* DELETE CONTACTS */
      System.out.println("-".repeat(35));
      System.out.println("Deleting Kojo's contact");
      list.Delete("Kojo");

      System.out.println("Deleting Kofi's contact");
      list.Delete("Kofi");
      System.out.println("-".repeat(35));

      System.out.println();

      // display contact list
      System.out.println("Displaying phone directory...");
      System.out.println("-".repeat(35));
      list.Print();

      System.out.println();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
