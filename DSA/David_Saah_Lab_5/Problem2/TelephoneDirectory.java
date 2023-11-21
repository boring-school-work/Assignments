/**
 * TelephoneDirectory handles the storage a user's contacts.
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-11-21
 */
public class TelephoneDirectory {
  private BinarySearchTree contactList;

  /**
   * Telephone Directory constructor
   */
  public TelephoneDirectory() {
    contactList = new BinarySearchTree();
  }

  /**
   * Insert a new contact into the directory
   *
   * @param contact the contact to be added
   */
  public void Insert(Contact contact) {
    contactList.insert(contact);
  }

  /**
   * Search for a contact in the TelephoneDirectory
   *
   * @param name the name of the contact
   *
   * @return the telephone number of the contact
   * @throws Exception if the contact does not exist
   */
  public String Search(String name) throws Exception {
    return contactList.search(name).getTelephone();
  }

  /**
   * Deletes a contact in the TelephoneDirectory
   *
   * @param name the name of the contact to delete
   *
   * @throws Exception if the contact does not exist
   */
  public void Delete(String name) throws Exception {
    contactList.delete(name);
  }

  /**
   * Displays the TelephoneDirectory
   */
  public void Print() {
    contactList.display();
  }
}
