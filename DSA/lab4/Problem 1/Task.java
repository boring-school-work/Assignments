/**
 * Task class defines the structure of a task
 *
 * @author David Saah
 * @since 2023-10-14
 * @version 1.0
 *
 */
public class Task {
  private String task_id; // unique id for each task
  private String description; // description of task
  private String status; // status of a task whether pending or completed
  private int priority; // 0-5: Normal, 5-10: High

  /**
   * Initialise a new task
   *
   * @param task_id     unique id for each task
   * @param description description of task
   * @param priority    0-5: Normal, 5-10: High
   */
  public Task(String task_id, String description, int priority) {
    this.task_id = task_id;
    this.description = description;
    this.status = "pending";
    this.priority = priority;
  }

  /**
   * Gets the task id
   *
   * @return the task id
   */
  public String getTask_id() {
    return task_id;
  }

  /**
   * Gets the task description
   *
   * @return the task description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the task status
   *
   * @return the task status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Get the task priority
   *
   * @return the task priority
   */
  public int getPriority() {
    return priority;
  }

  /**
   * Marks task as processed
   */
  public void process() {
    this.status = "completed";
  }

  @Override
  public String toString() {
    return "Task [ task_id: " + task_id + ", description: " + description
        + ", status: " + status + ", priority: " + priority + " ]";
  }

}
