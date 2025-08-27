package clippy.command;

import clippy.ClippyException;
import clippy.storage.Storage;
import clippy.task.DeadlineTask;
import clippy.task.Task;
import clippy.task.TaskList;
import clippy.ui.Ui;

public class AddDeadlineCommand extends Command {
    private final String payload;

    public AddDeadlineCommand(String payload) {
        this.payload = payload == null ? "" : payload.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException {
        String[] parts = payload.split(" /by ", 2);
        if (parts.length < 2) {
            throw new ClippyException("A deadline must have a set deadline (use '/by <yyyy-MM-dd>').");
        }
        Task t = new DeadlineTask(parts[0], parts[1]);
        tasks.add(t);
        storage.save(tasks.getAll());
        ui.showAdded(t, tasks.size());
    }
}
