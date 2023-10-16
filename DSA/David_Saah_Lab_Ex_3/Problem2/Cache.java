/**
 * Implement a list-based cache
 *
 * It stores a fixed number of items. When a new item is added to the cache,
 * the least recently used item should be evicted
 *
 * @author David Saah
 * @since 09-10-2023
 * @version 1.0
 */
public class Cache<T> {
  private int size = 0; // tracks the size of the cache list
  private int limit; // holds the maximum cache size
  private Node<T> head; // holds the address of the first node
  private Node<T> tail; // holds the address of the last node

  /**
   * Constructor to initialise the size of the cache
   * 
   * @param limit the size of the cache
   */
  public Cache(int limit) {
    this.limit = limit;
  }

  /**
   * Removes the tail node from the cache list
   *
   * @return the tail node of the cache list
   */
  public T EvictLeastRecentlyUsedItem() {
    T item = tail.data;
    RemoveItem(tail);

    return item;
  }

  /**
   * Insert an item into the cache list
   * 
   * @param data the data to insert into the cache
   */
  public void AddItem(T data) {
    // check if cache is full
    // evict least recently used cache item
    if (getSize() == limit) {
      EvictLeastRecentlyUsedItem();
    }

    Node<T> newNode = new Node<T>(data);

    newNode.next = head; // set the next node to point to the head
    newNode.prev = null; // set the previous node to point to null
    head = newNode; // set head to the new node
    size++; // increase cache size

    if (size == 1) {
      tail = head;
    } else if (size == 2) {
      tail.prev = newNode;
    }
  }

  /**
   * Removes an item from the cache list
   * 
   * @param item the node pointing to the item to be removed
   */
  private void RemoveItem(Node<T> item) {
    Node<T> current = head;

    if (tail.equals(item)) {
      tail = tail.prev;
      tail.next = null;
      size--;
      return;
    }

    while (!current.equals(item)) {
      current = current.next;
    }

    current = current.next;
    current.prev = current;
    size--;
  }

  /**
   * Gets an item from the cache
   *
   * Searches for the item. If it found, it should be moved to the head
   * of the list and returned. Else null is returned
   *
   * @param item the item to search for
   * @return item from the cache
   */
  public T GetItem(T item) {
    Node<T> current = head;

    while (current != null) {
      if (current.data == item) {
        RemoveItem(current);
        AddItem(item);
        return item;
      }

      current = current.next;
    }

    return null;
  }

  /**
   * Gets the size of the cache
   * 
   * @return the size of the cache
   */
  public int getSize() {
    return size;
  }

  /**
   * Display the items in the cache
   */
  public void display() {
    Node<T> current = head;

    System.out.print("[ ");

    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    System.out.print("]");
    System.out.println();
  }
}

/**
 * A node contains data and a reference
 */
class Node<T> {
  T data; // holds the data of a node
  Node<T> next; // holds the pointer to the next node
  Node<T> prev; // holds the pointer to the prev node

  public Node(T data) {
    this.data = data;
  }

  /**
   * Check if any items are the same
   *
   * @param otherItem the other item to compare with
   * @return whether the items are the same
   *
   */
  public boolean equals(Node<T> otherItem) {
    return this.data == otherItem.data;
  }
}
