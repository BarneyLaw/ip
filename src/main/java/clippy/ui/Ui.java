package clippy.ui;

import java.util.Scanner;

import clippy.task.Task;
import clippy.task.TaskList;

public class Ui {
    private static final String horizontalLine =
            "____________________________________________________________________";
    private final Scanner scanner = new Scanner(System.in);
    private final String logo =
    "         __                        \n" +
    "        /  \\        _____________  \n" +
    "        |  |       /             | \n" +
    "        @  @       |             | \n" +
    "        || ||      |  Hello!     | \n" +
    "        || ||   <--|             | \n" +
    "        |\\_/|      |             | \n" +
    "        \\___/      \\_____________/ \n";

    public Ui() {
    }

    /**
     * Displays the welcome message to the user.
     */
    public void welcome() {
        String message =  "Hello from Clippy\n"
                + this.logo + "\nWhat can I do for you?";
        System.out.println(wrapWithLines(message));
    }

    /**
     * Displays the goodbye message to the user.
     */
    public void goodbye() {
        String message = "Bye. Hope to see you again soon!";
        System.out.println(wrapWithLines(message));
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Displays the error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(wrapWithLines(message));
    }

    /**
     * Displays the newly added task and the total number of tasks in the list.
     *
     * @param task  The task that was added.
     * @param total The total number of tasks in the list after adding the new task.
     */
    public void showAdded(Task task, int total) {
        String message = "Got it. I've added this task:\n  " + task
                + "\nNow you have " + total + " tasks in the list.";
        System.out.println(wrapWithLines(message));
    }

    /**
     * Displays the deleted task and the total number of tasks remaining in the list.
     *
     * @param task the task that was added
     * @param total the total number of tasks in the list after deleting the task
     */
    public void showDeleted(Task task, int total) {
        String message = "Noted. I've removed this task:\n" + task
                + "\nNow you have " + total + " tasks in the list.";
        System.out.println(wrapWithLines(message));
    }

    /**
     * Displays the task that was marked as done.
     *
     * @param task The TaskList object containing all the tasks.
     */
    public void showMarked(Task task) {
        String message = "Nice! I've marked this task as done:\n" + task;
        System.out.println(wrapWithLines(message));
    }

    /**
     *  Displays the task that was unmarked.
     *
     * @param task The TaskList object containing all the tasks.
     */
    public void showUnmarked(Task task) {
        String message = "OK, I've marked this task as not done yet:\n" + task;
        System.out.println(wrapWithLines(message));
    }

    public static String wrapWithLines(String message) {
        return horizontalLine + "\n" + message + "\n" + horizontalLine;
    }

    public void showLine() {
        System.out.println(horizontalLine);
    }

}