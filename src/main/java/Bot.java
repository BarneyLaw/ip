public class Bot {
    private final String botName = "Clippy";
    private String greeting;
    private String goodbye;
    private String horizontalLine = "______________________________________________________________________________";

    public Bot() {
        greeting = "Hello, I'm Clippy \n"
                + "What can I do for you?";
        goodbye = "Bye. Hope to see you soon !";
    }

    public String greet() {
        return this.greeting;
    }

    public String bye() {
        return this.goodbye;
    }

    public String line() {
        return this.horizontalLine;
    }

}
