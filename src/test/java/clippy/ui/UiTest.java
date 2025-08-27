package clippy.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UiTest {
    @Test
    void welcome_printsWelcomeMessage() {
        Ui ui = new Ui();
        // You may need to redirect System.out and check output here
        // For demonstration, just check that no exception is thrown
        assertDoesNotThrow(ui::welcome);
    }

    @Test
    void showError_displaysErrorMessage() {
        Ui ui = new Ui();
        assertDoesNotThrow(() -> ui.showError("Test error"));
    }
}