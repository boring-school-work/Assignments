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
   * Finds the minimum element in a subtree
   *
   * @param parent the root of the subtree
   *
   * @return the ('minimum') contact on the subtree
   */
  private Contact findMin(Node parent) {
    Contact min_data = parent.data;

    while (parent.left != null) {
      min_data = parent.left.data;
      parent = parent.left;
    }

    return min_data;
  }

  /**
   * Deletes a contact from the binary search tree
   * 
   * @param name the name of the contact to be deleted
   * 
   * @throws Exception if the contact is not found
   */
  public void delete(String name) throws Exception {
    root = delete(name, root);
  }

  /**
   * Deletes a contact from the binary search tree
   * 
   * @param name the name of the contact to be deleted
   * @param root the tree to delete the contact from
   * 
   * @return the tree with the contact deleted
   * @throws Exception if the contact is not found
   */
  public Node delete(String name, Node root) throws Exception {
    // if the contact is not found
    if (root == null) {
      throw new Exception("Contact not found");
    }

    // if key > root's key, go to right subtree
    // else go to left subtree
    if (name.compareTo(root.data.getName()) > 0) {
      root.right = delete(name, root.right);
    } else if (name.compareTo(root.data.getName()) < 0) {
      root.left = delete(name, root.left);
    } else {
      // found the contact to be deleted

      // delete contact if it has no leaf nodes
      if (root.left == null && root.right == null) {
        root = null;
      }

      // set root to point to the leaf node remaining on the subtree
      else if (root.left == null) {
        root = root.right;
      } else if (root.right == null) {
        root = root.left;
      }

      // if the contact is not a leaf node but a subtree
      else {
        Contact min_data = findMin(root.right);

        // replace the data of root with the 'minimum' element from the subtree
        // it is updated in the parent tree
        root.data = min_data;

        // recursively delete the 'minimum' contact element from the subtree
        root.right = delete(min_data.getName(), root.right);
      }
    }

    return root;
  }

  /**
   * Performs inorder traversal on the BinarySearchTree
   *
   * @param parent the parent of the tree
   */
  private void inorder(Node parent) {
    if (parent != null) {
      inorder(parent.left);
      System.out.printf("Name: %s, Telephone: %s\n", parent.data.getName(), parent.data.getTelephone());
      inorder(parent.right);
    }
  }

  /**
   * Displays all the nodes in tree
   */
  public void display() {
    inorder(root);
  }
}
