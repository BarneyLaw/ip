public class Bot {
    private final String botName = "Clippy";
    private String greeting;
    private String goodbye;
    private String horizontalLine = "______________________________________________________________________________";

    public Bot() {
        greeting = "Hello, I'm Clippy \n"
                + "What can I do for you?";
        goodbye = "Bye. Hope to see you soon!";
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

}
