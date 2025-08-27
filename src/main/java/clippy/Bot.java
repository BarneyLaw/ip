package clippy;

import clippy.storage.Storage;
import clippy.task.DeadlineTask;
import clippy.task.EventTask;
import clippy.task.Task;
import clippy.task.ToDoTask;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    private final String botName = "clippy.Clippy";
    private List<Task> taskList = new ArrayList<>();
    private Storage storage;
    private String greeting;
    private String goodbye;
    private String horizontalLine = "______________________________________________________________________________";

    public Bot() {
        this.storage = new Storage();
        this.taskList = storage.load();
        greeting = "Hello, I'm clippy.Clippy \n"
                + "What can I do for you?";
        goodbye = "Bye. Hope to see you again soon!";
    }

    public void addToDo(String input) throws ClippyException {
        if (input == null || input.trim().isEmpty()) {
            throw new ClippyException("Oops! You need to provide a description for a todo.");
        }
        try {
            Task newTask = new ToDoTask(input);
            taskList.add(newTask);
            printAddTask(newTask);
            storage.save(taskList);
        } catch (ClippyException e) {
            System.out.println(horizontalLine);
            System.out.println(e.getMessage());
            System.out.println(horizontalLine);
        }
    }

    public void addDeadline(String input) {
        String[] parts = input.split(" /by ", 2);
        try {
            Task newTask = new DeadlineTask(parts[0], parts.length > 1 ? parts[1] : "");
            taskList.add(newTask);
            printAddTask(newTask);
            storage.save(taskList);
        } catch (ClippyException e) {
            System.out.println(horizontalLine);
            System.out.println(e.getMessage());
            System.out.println(horizontalLine);
        }
    }

    public void addEvent(String input) {
        String[] fromSplit = input.split(" /from ", 2);
        String description = fromSplit[0];
        String from = "", to = "";
        if (fromSplit.length > 1) {
            String[] toSplit = fromSplit[1].split(" /to ", 2);
            from = toSplit[0];
            if (toSplit.length > 1) {
                to = toSplit[1];
            }
        }
        try {
            Task newTask = new EventTask(description, from, to);
            taskList.add(newTask);
            printAddTask(newTask);
            storage.save(taskList);
        } catch (ClippyException e) {
            System.out.println(horizontalLine);
            System.out.println(e.getMessage());
            System.out.println(horizontalLine);
        }
    }

    public String greet() {
        return line() + "\n"
                + this.greeting +  "\n"
                + line();

    }

    public String bye() {
        return line() + "\n"
                + this.goodbye + "\n"
                + line();
    }

    public String line() {
        return this.horizontalLine + "\n";
    }

    private void printAddTask(Task task) {
        System.out.println(line() + "Got it. I've added this task:\n  " + task + "\nNow you have " + taskList.size() + " tasks in the list.\n" + line());
    }

    public void markTask(int index) throws ClippyException {
        if (taskList.isEmpty()) {
            throw new ClippyException("You have no tasks in the list to mark.");
        }
        if (index < 1 || index > taskList.size()) {
            throw new ClippyException("Please enter a task Number between 1 and " + taskList.size() + ".");
        }
        Task task = taskList.get(index - 1);
        task.markAsCompleted();
        storage.save(taskList);
        System.out.println(line() + "\n"
                + "Nice! I've marked this task as done:\n"
                + task + "\n" + line()
        );
    }

    public void unmarkTask(int index) throws ClippyException {
        if (taskList.isEmpty()) {
            throw new ClippyException("You have no tasks in the list to unmark.");
        }
        if (index < 1 || index > taskList.size()) {
            throw new ClippyException("Please enter a task Number between 1 and " + taskList.size() + ".");
        }
        Task task = taskList.get(index - 1);
        task.markAsIncomplete();
        storage.save(taskList);
        System.out.println(line() + "\n"
                + "OK, I've marked this task as not done yet:\n"
                + task + "\n" + line()
        );
    }

    public void deleteTask(String idx) throws ClippyException {
        int index = idx.isEmpty() ? -1 : Integer.parseInt(idx.trim());
        if (taskList.isEmpty()) {
            throw new ClippyException("You have no tasks in the list to delete.");
        }
        if (index < 1 || index > taskList.size()) {
            throw new ClippyException("Please enter a task Number between 1 and " + taskList.size() + ".");
        }
        Task task = taskList.remove(index - 1);
        storage.save(taskList);
        System.out.println(line() + "\n"
                + "Noted. I've removed this task:\n"
                + task
                + "\nNow you have " + taskList.size() + " tasks in the list.\n"
                + line()
        );
    }

    public String listToString() {
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        int index = 1;
        for (Task task : taskList) {
            sb.append(index)
                .append(".")
                .append(task.toString())
                .append("\n");
            index++;
        }
        sb.append(String.format("You have %d tasks in the list.\n", taskList.size()));
        return sb.toString();
    }

}
