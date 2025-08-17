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
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (Task task : taskList) {
            sb.append(index)
                .append(".")
                .append(task.toString())
                .append("\n");
            index++;
        }
        return sb.toString();
    }

}
