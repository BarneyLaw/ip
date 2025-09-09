package clippy;

import java.util.List;

import clippy.command.Command;
import clippy.parser.Parser;
import clippy.storage.Storage;
import clippy.task.Task;
import clippy.task.TaskList;
import clippy.ui.Ui;

/**
 * The main class for the Clippy application, a command-line task manager.
 * It initializes the UI, storage, and task list, and runs the main command loop.
 */
public class Clippy {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;
    private String commandType;

    /**
     * Constructs a Clippy application instance, initializing the UI, storage, and task list.
     */
    public Clippy() {
        this.ui = new Ui();
        this.storage = new Storage();
        List<Task> loaded = storage.load();
        this.tasks = new TaskList(loaded);
        assert this.tasks != null : "TaskList should be initialized";
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
                assert c != null : "Parsed Command should not be null";
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (ClippyException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("Unexpected error: " + e.getMessage());
            }
        }
    }

    public String getWelcome() {
        StringBuilder sb = new StringBuilder();
        Ui sinkUi = new Ui(s -> sb.append(s).append(System.lineSeparator()));
        sinkUi.welcome();
        return sb.toString().trim();
    }

    public String getResponse(String input) {
        StringBuilder sb = new StringBuilder();
        Ui sinkUi = new Ui(s -> sb.append(s).append(System.lineSeparator()));
        try {
            Command c = Parser.parse(input);
            assert c != null : "Parsed Command should not be null";
            c.execute(tasks, sinkUi, storage);
            commandType = c.getClass().getSimpleName();
        } catch (ClippyException e) {
            sinkUi.showError(e.getMessage());
        } catch (Exception e) {
            sinkUi.showError("Unexpected error: " + e.getMessage());
        }
        return sb.toString().trim();
    }

    public String getCommandType() {
        return commandType;
    }

    public static void main(String[] args) {
        new Clippy().run();
    }
}
