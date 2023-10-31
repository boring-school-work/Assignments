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
   * Add a new task based on priority
   * [0-5] --> Normal priority
   * [6-10] --> High priority
   *
   * @param task the task to be added
   * @throws error stack is empty, priority is out of range
   */
  public void addTask(Task task) throws Exception {
    // throw an error if priority is out of range
    if (task.getPriority() > 10 || task.getPriority() < 0) {
      throw new Exception("Error: Cannot add task, priority is out of range.\nFix: Choose between 0 to 10 inclusive");
    }

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
