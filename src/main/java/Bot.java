import java.util.ArrayList;
import java.util.List;

public class Bot {
    private final String botName = "Clippy";
    private List<Task> taskList = new ArrayList<>();
    private String greeting;
    private String goodbye;
    private String horizontalLine = "______________________________________________________________________________";

    public Bot() {
        greeting = "Hello, I'm Clippy \n"
                + "What can I do for you?";
        goodbye = "Bye. Hope to see you soon!";
    }

    public void addToDo(String input) {
        Task newTask = new ToDoTask(input);
        taskList.add(newTask);
        printAddTask(newTask);
    }

    public void addDeadline(String input) {
        String[] parts = input.split(" /by ", 2);
        Task newTask = new DeadlineTask(parts[0], parts.length > 1 ? parts[1] : "");
        taskList.add(newTask);
        printAddTask(newTask);
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
        Task newTask = new EventTask(description, from, to);
        taskList.add(newTask);
        printAddTask(newTask);
    }

    public void addToList(String input) {
        Task newTask = new Task(input.trim());
        taskList.add(newTask);

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

    public void markTask(int index) {
        Task task = taskList.get(index - 1);
        task.markAsCompleted();
        System.out.println(line() + "\n"
                + "Nice! I've marked this task as done:\n"
                + task + "\n" + line()
        );
    }

    public void unmarkTask(int index) {
        Task task = taskList.get(index - 1);
        task.markAsIncomplete();
        System.out.println(line() + "\n"
                + "OK, I've marked this task as not done yet:\n"
                + task + "\n" + line()
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
