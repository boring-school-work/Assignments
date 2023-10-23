/**
 * Stack data structure implmentation for a task management system
 *
 * @author David Saah
 * @since 2023-10-23
 * @version 1.0
 *
 */
public class Stack {
  Node top; // top of the stack
  int size = 0; // size of the stack

  /**
   * Add a task to the stack
   *
   * @param task the task to add to the stack
   */
  public void push(Task task) {
    Node newNode = new Node(task);

    newNode.next = top;
    top = newNode;
    size++;
  }

  /**
   * Removes and returns the top task from the stack
   * 
   * @return the top task from the stack
   * @throws error stack is empty
   */
  public Task pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty");
    }

    Task task = top();

    top = top.next;
    size--;

    return task;
  }

  /**
   * Return the top task without removing it
   * 
   * @return the top of the task
   */
  public Task top() {
    return top.data;
  }

  /**
   * Check if stack is empty
   * 
   * @return whether the stack is empty or not
   */
  public boolean isEmpty() {
    return size == 0;
  }
}
