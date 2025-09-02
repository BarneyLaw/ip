package clippy.command;

import clippy.ClippyException;
import clippy.storage.Storage;
import clippy.task.Task;
import clippy.task.TaskList;
import clippy.ui.Ui;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private final int indexZeroBased;

    /**
     * Constructs a DeleteCommand with the specified 1-based index.
     *
     * @param indexOneBased The 1-based index of the task to be deleted.
     */
    public DeleteCommand(int indexOneBased) {
        this.indexZeroBased = indexOneBased - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException {
        if (tasks.size() == 0) {
            throw new ClippyException("You have no tasks in the list to delete.");
        }
        Task removed = tasks.remove(indexZeroBased);
        storage.save(tasks.getAll());
        ui.showDeleted(removed, tasks.size());
    }
}
