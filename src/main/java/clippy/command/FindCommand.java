package clippy.command;

import clippy.task.TaskList;
import clippy.ui.Ui;
import clippy.storage.Storage;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFound(tasks.findTasks(keyword));
    }
}