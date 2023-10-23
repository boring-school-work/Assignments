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

  private enum task_status {
    PENDING, COMPLETED
  };

  private task_status status; // pending or completed
  private int priority; // 0-5: Normal, 5-10: High

  /**
   * Initialise a new task
   *
   * @param task_id     unique id for each task
   * @param description description of task
   * @param status      state of the task pending or completed
   * @param priority    0-5: Normal, 5-10: High
   */
  public Task(String task_id, String description, task_status status, int priority) {
    this.task_id = task_id;
    this.description = description;
    this.status = status;
    this.priority = priority;
  }
}
