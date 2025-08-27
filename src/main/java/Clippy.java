import java.util.List;

public class Clippy {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Clippy() {
        this.ui = new Ui();
        this.storage = new Storage();
        List<Task> loaded = storage.load();
        this.tasks = new TaskList(loaded);
    }

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