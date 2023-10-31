/**
 * Queue data structure implementation for a task management system
 *
 * @author David Saah
 * @since 2023-10-23
 * @version 1.0
 */
public class Queue {
  private Node front; // pointer to the front of the queue
  private Node rear; // pointer to the end of the queue
  private int size = 0; // size of the queue

  /**
   * Add new task at the end of the queue
   *
   * @param task the task to be added
   */
  public void enqueue(Task task) {
    Node newNode = new Node(task);

    // if the queue is empty
    // front and rear will point to the same node
    if (size == 0) {
      front = newNode;
      rear = newNode;
      size++;
      return;
    }

    // add the new node at the end of the queue
    newNode.prev = rear;
    rear.next = newNode;
    rear = newNode;

    // if the queue has only one element,
    // the next pointer of the front should point to the rear.
    // This prevents the next pointer for front from pointing
    // to null, breaking the link
    if (size == 1) {
      front.next = rear;
    }

    size++;
  }

  /**
   * Removes the task at the end of the queue
   *
   * @return the task that was removed
   * @throws error the queue is empty
   */
  public Task dequeue() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty");
    }

    Task task = front(); // get the task at the front of the queue

    // delete the task at the front of the queue
    front = front.next;
    size--;
    return task;
  }

  /**
   * Returns the task at the front of the queue without removing it
   *
   * @return the task at the front of the queue
   * @throws error the queue is empty
   */
  public Task front() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty");
    }

    return front.data;
  }

  /**
   * Checks if the queue is empty
   *
   * @return whether the queue is empty or not
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Display the queue
   * 
   * @throws error queue is empty
   */
  public void display() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty");
    }

    Node current = front;

    while (current != null) {
      System.out.print(current.data.toString());
      System.out.println();
      current = current.next;
    }

    System.out.println();
  }
}
