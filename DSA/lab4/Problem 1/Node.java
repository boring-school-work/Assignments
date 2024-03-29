/**
 * A node to use in a linked list
 *
 * @author David Saah
 * @since 2023-10-23
 * @version 1.0
 */
class Node {
  Node next; // pointer to the next node
  Node prev; // pointer to the previous node
  Task data; // data contained in the node

  /**
   * Constructor for a node
   *
   * @param data the task to store in the node
   *
   */
  public Node(Task data) {
    this.data = data;
  }
}
