package clippy.command;

import clippy.ClippyException;
import clippy.storage.Storage;
import clippy.task.TaskList;
import clippy.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException;
    public boolean isExit() {
        return false;
    }
}
