package clippy;

import clippy.command.Command;
import clippy.parser.Parser;
import clippy.storage.Storage;
import clippy.task.Task;
import clippy.task.TaskList;
import clippy.ui.Ui;

import java.util.List;

public class Clippy {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a Clippy application instance, initializing the UI, storage, and task list.
     */
    public Clippy() {
        this.ui = new Ui();
        this.storage = new Storage();
        List<Task> loaded = storage.load();
        this.tasks = new TaskList(loaded);
    }

    /**
     * Starts the Clippy application, displaying the welcome message and entering the command loop.
     */
    public void run() {
        ui.welcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (ClippyException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Clippy().run();
    }
}