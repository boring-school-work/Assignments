/**
 * Task Management System implementation
 *
 * @author David Saah
 * @since 2023-20-23
 * @version 1.0
 *
 */
class TaskMS {
  private Queue normal_tasks; // hold normal tasks
  private Stack priority_tasks; // hold the priority tasks
  private Queue processed_tasks; // holds the processed tasks the user wishes to store

  /**
   * Initialise task lists
   */
  public TaskMS() {
    normal_tasks = new Queue();
    processed_tasks = new Queue();
    priority_tasks = new Stack();
  }

  /**
   * Add a new task
   *
   * @param task the task to be added
   */
  public void addTask(Task task) {
    if (task.getPriority() > 5) {
      priority_tasks.push(task);
    } else {
      normal_tasks.enqueue(task);
    }

    System.out.println();
    System.out.println("New task added successfully");
  }

  /**
   * Stores processed tasks
   *
   * @param task the task to be stored
   *
   */
  public void storeProcessedTask(Task task) {
    processed_tasks.enqueue(task);

    System.out.println();
    System.out.println("Stored processed task");
  }

  /**
   * Processes a task
   * 
   * @return processed task
   * @throws error list is empty
   */
  public Task processTask() throws Exception {
    Task task;

    if (!priority_tasks.isEmpty()) {
      task = priority_tasks.pop();
    } else {
      task = normal_tasks.dequeue();
    }

    System.out.println();
    System.out.println("Processed task successfully");

    return task;
  }

  /**
   * Display queue
   * 
   * @throws error queue is empty
   */
  public void displayQueue() throws Exception {
    System.out.println();
    System.out.println("Queue: ");

    normal_tasks.display();
  }

  /**
   * Display stack
   * 
   * @throws error stack is empty
   */
  public void displayStack() throws Exception {
    System.out.println();
    System.out.println("Stack: ");

    priority_tasks.display();
  }

  /**
   * Display processed tasks
   * 
   * @throws error queue is empty
   */
  public void displayProcessed() throws Exception {
    System.out.println();
    System.out.println("Processed: ");

    processed_tasks.display();
  }
}
