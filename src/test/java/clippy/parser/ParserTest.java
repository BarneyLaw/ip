package clippy.parser;

import clippy.ClippyException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import clippy.command.Command;
import clippy.command.AddTodoCommand;

class ParserTest {
    @Test
    void parseTodoCommand_returnsTodoTask() {
        String input = "todo read book";
        try {
            Command command = Parser.parse(input);
            assertTrue(command instanceof AddTodoCommand);
        } catch (ClippyException e) {
            fail("Parsing failed with exception: " + e.getMessage());
        }
    }

    @Test
    void parseInvalidCommand_throwsException() {
        String input = "invalid command";
        assertThrows(ClippyException.class, () -> Parser.parse(input));
    }
}
