package clippy.task;

import clippy.ui.Ui;

import java.util.ArrayList;
import java.util.List;

import clippy.ClippyException;

public class TaskList {
    private final List<Task> tasks;

    /**
     * Initializes an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Initializes a TaskList with the given list of tasks.
     * Used when loading from storage.
     *
     * @param tasks The list of tasks to initialize the TaskList with.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Retrieves the task at the specified index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Removes the task at the specified index.
     *
     * @param index The index of the task to remove.
     * @return The removed task.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return The number of tasks.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns true if the task list is empty, false otherwise.
     *
     * @return true if the task list is empty, false otherwise.
     */
    public List<Task> getAll() {
        return tasks;
    }

    public List<Task> findTasks(String keyword) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                result.add(task);
            }
        }
        return result;
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
        sb.append(String.format("You have %d tasks in the list.", tasks.size()));
        return Ui.wrapWithLines(sb.toString());
    }

}
