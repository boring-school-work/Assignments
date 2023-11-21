/**
 * Binary Search Tree implementation for telephone directory
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-11-21
 */
public class BinarySearchTree {
  private Node root;

  /**
   * BinarySearchTree constructor
   */
  public BinarySearchTree() {
    root = null;
  }

  /**
   * Inserts a contact into the binary search tree
   * 
   * @param contact the contact to be inserted
   */
  public void insert(Contact contact) {
    Node newNode = new Node(contact); // create new node

    // check if tree is empty
    if (root == null) {
      root = newNode;
      return;
    }

    Node parent = null;
    Node temp = root;

    // find the parent of the new node
    while (temp != null) {
      parent = temp;

      // if key > temp's key, go to right subtree
      // else go to left subtree
      if (newNode.compareTo(temp) > 0) {
        temp = temp.right;
      } else {
        temp = temp.left;
      }
    }

    // if key < parent, insert to left of parent
    // if key > parent, insert to right of parent
    if (newNode.compareTo(parent) < 0) {
      parent.left = newNode;
    } else {
      parent.right = newNode;
    }
  }

  /**
   * Searches for a contact in the binary search tree
   * 
   * @param name the name of the contact to be searched
   * 
   * @return the contact if found
   * @throws Exception if the contact is not found
   */
  public Contact search(String name) throws Exception {
    Node temp = root;

    // traverse the tree until the node is found
    while (temp != null) {
      // if name = temp's name, return temp
      if (name.compareTo(temp.data.getName()) == 0) {
        return temp.data;
      }

      // if name < temp's name, go to left subtree
      else if (name.compareTo(temp.data.getName()) < 0) {
        temp = temp.left;
      }

      // if name > temp's name, go to right subtree
      else {
        temp = temp.right;
      }
    }

    throw new Exception("Contact not found");
  }

  /**
   * Deletes a contact from the binary search tree
   * 
   * @param name the name of the contact to be deleted
   * 
   * @throws Exception if the contact is not found
   */
  public void delete(String name) throws Exception {

  }
}
