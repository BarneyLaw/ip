public class DeleteCommand extends Command {
    private final int indexZeroBased;

    public DeleteCommand(int indexOneBased) {
        this.indexZeroBased = indexOneBased - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClippyException {
        if (tasks.size() == 0) {
            throw new ClippyException("You have no tasks in the list to delete.");
        }
        Task removed = tasks.remove(indexZeroBased);
        storage.save(tasks.getAll());
        ui.showDeleted(removed, tasks.size());
    }
}
