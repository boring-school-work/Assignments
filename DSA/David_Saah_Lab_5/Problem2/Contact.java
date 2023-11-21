/**
 * Contact class to store contact information
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-11-21
 */
public class Contact {
  private String name;
  private String telephone;

  /**
   * Contact constructor
   * 
   * @param name      the name of the contact
   * @param telephone the telephone number of the contact
   */
  public Contact(String name, String telephone) {
    this.name = name;
    this.telephone = telephone;
  }

  /**
   * Gets the name of the contact
   * 
   * @return the name of the contact
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the telephone number of the contact
   * 
   * @return the telephone number of the contact
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Sets the name of the contact
   * 
   * @param name the name of the contact
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the telephone number of the contact
   * 
   * @param telephone the telephone number of the contact
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

}
