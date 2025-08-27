import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public Task remove(int index) {
        return tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }

    public List<Task> getAll() {
        return tasks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        int index = 1;
        for (Task task : tasks) {
            sb.append(index)
                    .append(".")
                    .append(task.toString())
                    .append("\n");
            index++;
        }
        sb.append(String.format("You have %d tasks in the list.\n", tasks.size()));
        return sb.toString();
    }

}
