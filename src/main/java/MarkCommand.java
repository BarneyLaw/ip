public class MarkCommand extends Command {
    private final int indexZeroBased;

    public MarkCommand(int indexOneBased) {
        this.indexZeroBased = indexOneBased - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException {
        if (tasks.size() == 0) {
            throw new ClippyException("You have no tasks in the list to mark.");
        }
        Task t = tasks.get(indexZeroBased);
        t.markAsCompleted();
        storage.save(tasks.getAll());
        ui.showMarked(t);
    }
}
