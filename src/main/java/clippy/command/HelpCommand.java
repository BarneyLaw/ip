package clippy.command;

import clippy.storage.Storage;
import clippy.task.TaskList;
import clippy.ui.Ui;


public class HelpCommand extends Command {

    public HelpCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showHelp();
    }
}
