public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String description) {
        this.description = description == null
                                        ? ""
                                        : description.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException {
        if (description.isEmpty()) {
            throw new ClippyException("Oops! You need to provide a description for a todo.");
        }
        Task t = new ToDoTask(description);
        tasks.add(t);
        storage.save(tasks.getAll());
        ui.showAdded(t, tasks.size());
    }
}
