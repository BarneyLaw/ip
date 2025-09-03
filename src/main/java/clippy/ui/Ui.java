package clippy.ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import clippy.task.Task;
import clippy.task.TaskList;

/**
 * Handles user interaction and displays messages to the user.
 */
public class Ui {
    private static final String horizontalLine =
            "____________________________________________________________________";
    private final Scanner scanner = new Scanner(System.in);
    private final String logo =
              "         __                        \n"
            + "        /  \\        _____________  \n"
            + "        |  |       /             | \n"
            + "        @  @       |             | \n"
            + "        || ||      |  Hello!     | \n"
            + "        || ||   <--|             | \n"
            + "        |\\_/|      |             | \n"
            + "        \\___/      \\_____________/ \n";
    private Consumer<String> output;

    public Ui() {
        this.output = System.out::println;
    }

    /**
     * Constructs Ui instance with the specified output sink.
     * If the provided sink is null, defaults to standard output.
     *
     * @param sink The Consumer<String> to handle output messages.
     */
    public Ui(Consumer<String> sink) {
        this.output = (sink == null)
                    ? System.out::println
                    : sink;
    }

    /**
     * Sets the output sink for displaying messages.
     * If the provided sink is null, defaults to standard output.
     *
     * @param sink The Consumer<String> to handle output messages.
     */
    public void setSink(Consumer<String> sink) {
        this.output = (sink == null)
                    ? System.out::println
                    : sink;
    }

    /**
     * Displays the welcome message to the user.
     */
    public void welcome() {
        String message = "Hello from Clippy\n"
                + this.logo + "\nWhat can I do for you?";
        output.accept(message);
    }

    /**
     * Displays the goodbye message to the user.
     */
    public void goodbye() {
        String message = "Bye. Hope to see you again soon!";
        output.accept(message);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showList(TaskList tasks) {
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        int index = 1;
        for (Task t : tasks.getAll()) {
            sb.append(index).append(".").append(t.toString()).append("\n");
            index++;
        }
        sb.append(String.format("You have %d tasks in the list.\n", tasks.size()));

        output.accept(sb.toString().trim());

    }

    /**
     * Displays the error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        output.accept(message);
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
        output.accept(message);
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
        output.accept(message);
    }

    /**
     * Displays the task that was marked as done.
     *
     * @param task The TaskList object containing all the tasks.
     */
    public void showMarked(Task task) {
        String message = "Nice! I've marked this task as done:\n" + task;
        output.accept(message);
    }

    /**
     *  Displays the task that was unmarked.
     *
     * @param task The TaskList object containing all the tasks.
     */
    public void showUnmarked(Task task) {
        String message = "OK, I've marked this task as not done yet:\n" + task;
        output.accept(message);
    }

    /**
     * Wraps the given message with horizontal lines above and below it.
     * Only used in command-line interface to identify the message block.
     *
     * @param message The message to be wrapped.
     * @return The message wrapped with horizontal lines.
     */
    public static String wrapWithLines(String message) {
        return horizontalLine + "\n" + message + "\n" + horizontalLine;
    }

    /**
     * Displays a horizontal line to separate different sections of output.
     */
    public void showLine() {
        System.out.println(horizontalLine);
    }

    /**
     * Displays the list of tasks that match the search keyword.
     *
     * @param foundTasks The list of tasks that match the search keyword.
     */
    public void showFound(List<Task> foundTasks) {
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");
        int index = 1;
        for (Task task : foundTasks) {
            sb.append(index++).append(".").append(task.toString()).append("\n");
        }
        output.accept(sb.toString().trim());
    }
}
