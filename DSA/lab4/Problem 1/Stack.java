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
   * @throws error stack is empty
   */
  public void push(Task task) throws Exception {
    Stack tmp = new Stack(); // create a temporary stack for sorting priorities
    Node newNode = new Node(task);

    // pop all elements from stack that has greater priority than new task
    // Store the tasks in a temporary node
    while (top != null && newNode.data.getPriority() < top.data.getPriority()) {
      tmp.push(pop());
    }

    newNode.next = top; // set the next of the new node to the top
    top = newNode; // set the top to the new node
    size++;

    // repopulate stack with tasks in the temporary stack
    while (!tmp.isEmpty()) {
      push(tmp.pop());
    }
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

    Task task = top(); // get the top task

    // remove the top task
    top = top.next;
    size--;

    return task;
  }

  /**
   * Return the top task without removing it
   *
   * @return the top of the task
   * @throws error stack is empty
   */
  public Task top() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty");
    }

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

  /**
   * Display the stack
   * 
   * @throws error stack is empty
   */
  public void display() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty");
    }

    Node current = top;

    while (current != null) {
      System.out.print(current.data.toString());
      System.out.println();
      current = current.next;
    }

    System.out.println();
  }
}
