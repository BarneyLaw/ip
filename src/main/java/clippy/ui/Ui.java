package clippy.ui;

import java.util.Scanner;

import clippy.task.Task;
import java.util.List;

public class Ui {
    private static final String horizontalLine = "____________________________________________________________________";
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

    public void welcome() {
        String message =  "Hello from clippy.Clippy\n" + this.logo + "\nWhat can I do for you?";
        System.out.println(wrapWithLines(message));
    }

    public void goodbye() {
        String message = "Bye. Hope to see you again soon!";
        System.out.println(wrapWithLines(message));
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showError(String message) {
        System.out.println(wrapWithLines(message));
    }

    public void showAdded(Task task, int total) {
        String message = "Got it. I've added this task:\n  " + task
                + "\nNow you have " + total + " tasks in the list.";
        System.out.println(wrapWithLines(message));
    }

    public void showDeleted(Task task, int total) {
        String message = "Noted. I've removed this task:\n" + task
                + "\nNow you have " + total + " tasks in the list.";
        System.out.println(wrapWithLines(message));
    }

    public void showMarked(Task task) {
        String message = "Nice! I've marked this task as done:\n" + task;
        System.out.println(wrapWithLines(message));
    }

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

    public void showFound(List<Task> foundTasks) {
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");
        int index = 1;
        for (Task task : foundTasks) {
            sb.append(index++).append(".").append(task.toString()).append("\n");
        }
        System.out.println(wrapWithLines(sb.toString().trim()));
    }

}