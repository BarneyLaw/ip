package clippy.command;

import clippy.ClippyException;
import clippy.storage.Storage;
import clippy.task.EventTask;
import clippy.task.Task;
import clippy.task.TaskList;
import clippy.ui.Ui;

public class AddEventCommand extends Command {
    private final String payload;

    /**
     * Constructs an AddEventCommand with the specified payload.
     *
     * @param payload The payload containing the event description, start time, and end time.
     */
    public AddEventCommand(String payload) {
        this.payload = payload == null ? "" : payload.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException {
        String[] fromSplit = payload.split(" /from ", 2);
        if (fromSplit.length < 2) {
            throw new ClippyException("An event must have a starting time (use '/from <time>').");
        }
        String description = fromSplit[0];
        String[] toSplit = fromSplit[1].split(" /to ", 2);
        if (toSplit.length < 2) {
            throw new ClippyException("An event must have an ending time (use '/to <time>').");
        }
        Task t = new EventTask(description, toSplit[0], toSplit[1]);
        tasks.add(t);
        storage.save(tasks.getAll());
        ui.showAdded(t, tasks.size());
    }
}
