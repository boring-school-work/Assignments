/**
 * Node for Binary Search Tree implementation (for telephone directory)
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-11-21
 */
public class Node {
  Contact data;
  Node left;
  Node right;

  /**
   * Node constructor
   * 
   * @param contact the contact to be stored in the node
   */
  public Node(Contact contact) {
    this.data = contact;
    left = right = null;
  }

  /**
   * Overidden compareTo method
   * 
   * @param node the contact node to be compared
   * @return 0 if the nodes are equal, -1 if the name is less than the contact,
   *         and 1 if the name is greater than the contact
   */
  public int compareTo(Node another) {
    return data.getName().compareTo(another.data.getName());
  }
}
