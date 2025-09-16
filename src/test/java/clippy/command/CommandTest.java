package clippy.command;

import clippy.ClippyException;
import clippy.storage.Storage;
import clippy.task.Task;
import clippy.task.TaskList;
import clippy.ui.Ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Test class for Command and its subclasses.
 * Created with the aid of Copilot, mainly to generate boilerplate test methods through autocompletion.
 * The tests ensure that each command executes without throwing exceptions
 */
public class CommandTest {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    @BeforeEach
    void setUp() {
        storage = new Storage();
        tasks = new TaskList();
        ui = new Ui();
    }

    @Test
    void AddDeadlineCommand_executesWithoutError() {
        Command addDeadlineCommand = new AddDeadlineCommand("submit report /by 2024-12-01");
        assertDoesNotThrow(() -> addDeadlineCommand.execute(tasks, ui, storage));
        assertEquals(1, tasks.size());
        assertEquals("[D] [ ] submit report (by: Dec 1 2024)", tasks.get(0).toString());
    }

    @Test
    void AddToDoCommand_executesWithoutError() {
        Command addToDoCommand = new AddTodoCommand("read book");
        assertDoesNotThrow(() -> addToDoCommand.execute(tasks, ui, storage));
        assertEquals(1, tasks.size());
        assertEquals("[T] [ ] read book", tasks.get(0).toString());
    }

    @Test
    void AddEventCommand_executesWithoutError() {
        Command addEventCommand = new AddEventCommand("project /from 2024-11-15 /to 2024-11-16");
        assertDoesNotThrow(() -> addEventCommand.execute(tasks, ui, storage));
        assertEquals(1, tasks.size());
        assertEquals("[E] [ ] project (from: 2024-11-15 to: 2024-11-16)", tasks.get(0).toString());
    }

    @Test
    void DeleteCommand_executesWithoutError() throws ClippyException {
        tasks.add(new Task("read book"));
        Command deleteCommand = new DeleteCommand(1);
        assertDoesNotThrow(() -> deleteCommand.execute(tasks, ui, storage));
        assertEquals(0, tasks.size());
    }

    @Test
    void ListCommand_executesWithoutError() throws ClippyException {
        tasks.add(new Task("read book"));
        Command listCommand = new ListCommand();
        assertDoesNotThrow(() -> listCommand.execute(tasks, ui, storage));
    }

    @Test
    void MarkCommand_executesWithoutError() throws ClippyException {
        tasks.add(new Task("read book"));
        Command markCommand = new MarkCommand(1);
        assertDoesNotThrow(() -> markCommand.execute(tasks, ui, storage));
        assertTrue(tasks.get(0).isCompleted());
    }

    @Test
    void UnmarkCommand_executesWithoutError() throws ClippyException {
        Task task = new Task("read book");
        task.markAsCompleted();
        tasks.add(task);
        Command unmarkCommand = new UnmarkCommand(1);
        assertDoesNotThrow(() -> unmarkCommand.execute(tasks, ui, storage));
        assertFalse(tasks.get(0).isCompleted());
    }

    @Test
    void helpCommand_executesWithoutError() {
        Command helpCommand = new HelpCommand();
        assertDoesNotThrow(() -> helpCommand.execute(tasks, ui, storage));
    }

    @Test
    void findCommand_executesWithoutError() throws ClippyException {
        tasks.add(new Task("read book"));
        tasks.add(new Task("write code"));
        Command findCommand = new FindCommand("read");
        assertDoesNotThrow(() -> findCommand.execute(tasks, ui, storage));
    }

    @Test
    void isExit_returnsCorrectValue() {
        Command AddDeadlineCommand = new AddDeadlineCommand("submit report /by 2024-12-01");
        Command AddToDoCommand = new AddTodoCommand("read book");
        Command AddEventCommand = new AddEventCommand("team meeting /at 2024-11-15");
        Command DeleteCommand = new DeleteCommand(1);
        Command ListCommand = new ListCommand();
        Command MarkCommand = new MarkCommand(1);
        Command UnmarkCommand = new UnmarkCommand(1);
        Command helpCommand = new HelpCommand();
        Command findCommand = new FindCommand("read");

        assertFalse(AddDeadlineCommand.isExit());
        assertFalse(AddToDoCommand.isExit());
        assertFalse(AddEventCommand.isExit());
        assertFalse(DeleteCommand.isExit());
        assertFalse(ListCommand.isExit());
        assertFalse(MarkCommand.isExit());
        assertFalse(UnmarkCommand.isExit());
        assertFalse(helpCommand.isExit());
        assertFalse(findCommand.isExit());
    }
}
