import java.util.ArrayList;
import java.util.List;

public class Bot {
    private final String botName = "Clippy";
    private List<String> userInput = new ArrayList<>();
    private String greeting;
    private String goodbye;
    private String horizontalLine = "______________________________________________________________________________";

    public Bot() {
        greeting = "Hello, I'm Clippy \n"
                + "What can I do for you?";
        goodbye = "Bye. Hope to see you soon!";
    }

    public void addToList(String input) {
        if (input != null && !input.trim().isEmpty()) {
            userInput.add(input);
        }
    }

    public String greet() {
        return line() + "\n"
                + this.greeting +  "\n"
                + line();

    }

    public String bye() {
        return line() + "\n"
                + this.goodbye + "\n"
                + line();
    }

    public String line() {
        return this.horizontalLine + "\n";
    }

    public String listToString() {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (String input : userInput) {
            sb.append(index + ". ").append(input).append("\n");
            index += 1;
        }
        return sb.toString();
    }

}
