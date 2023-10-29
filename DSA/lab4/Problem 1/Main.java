import java.util.Scanner;

/**
 * Main class for the Task Management Program
 *
 * @author David Saah
 * @since 2023-20-23
 * @version 1.0
 *
 */
public class Main {
  public static void main(String[] args) {
    TaskMS taskms = new TaskMS();
    String id_pre = "T";
    int id_num = 220;
    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.println();
      System.out.println("1. Add Task");
      System.out.println("2. Process Task");
      System.out.println("3. View Stack");
      System.out.println("4. View Queue");
      System.out.println("5. View Stored Processed Tasks");
      System.out.println("6. Quit");
      System.out.println();

      System.out.print("Option: ");
      String option = input.nextLine();

      try {

        // add task
        if (option.equals("1")) {
          System.out.print("Task info: ");
          String desc = input.nextLine();

          System.out.print("Task priority: ");
          String priority = input.nextLine();

          taskms.addTask(new Task(id_pre + id_num, desc, Integer.valueOf(priority)));
          id_num++;
          System.out.println();
        }

        // process task
        else if (option.equals("2")) {
          Task task = taskms.processTask();

          System.out.print("Do you want to store processed task? [y/n]: ");
          if (input.nextLine().equals("y")) {
            task.process();
            taskms.storeProcessedTask(task);
          }

          System.out.println();
        }

        // view stack
        else if (option.equals("3")) {
          taskms.displayStack();
          System.out.println();
        }

        // view queue
        else if (option.equals("4")) {
          taskms.displayQueue();
          System.out.println();
        }

        // view processed tasks
        else if (option.equals("5")) {
          taskms.displayProcessed();
          System.out.println();
        }
        // exit the program
        else if (option.equals("6")) {
          break;
        }

        // invalid option
        else {
          System.out.println("Invalid option, try again");
          System.out.println();
          continue;
        }
      } catch (Exception e) {
        System.out.println(e);
        System.out.println();
      }
    }

    input.close();
  }
}
