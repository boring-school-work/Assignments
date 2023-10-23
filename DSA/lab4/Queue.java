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

    newNode.prev = rear;
    rear.next = newNode;
    rear = newNode;
    size++;

    if (size == 1) {
      front = rear;
    }
  }

  /**
   * Removes the task at the end of the queue
   * 
   * @return the task that was removed
   */
  public Task dequeue() throws Exception {
    Task task = front();
    front = front.next;
    size--;
    return task;
  }

  /**
   * Returns the task at the front of the queue without removing it
   * 
   * @return the task at the front of the queue
   */
  public Task front() {
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
}
