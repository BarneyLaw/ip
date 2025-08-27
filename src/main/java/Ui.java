import java.util.Scanner;

public class Ui {
    private static final String horizontalLine = "____________________________________________________________________";
    private final Scanner scanner = new Scanner(System.in);
    private final String logo = "⠀⠀⠀⠀⠀⠀    ⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠟⠛⠛⠻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣾⣧⡀⠀⠀⠀⢸⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠛⠋⠰⡟⠉⠁⠀⠀⠀⣾⣯⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⡀⢰⣶⣶⣌⢳⡀⠀⠀⠀⠛⠿⣿⡿⣖⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠳⣜⣻⢿⣋⡾⠃⢰⠃⣴⣶⣶⡄⢻⣿⡾⡿⠿⠿⠿⠿⠶⠒⣳⠋⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹⣿⠉⠀⣰⣿⣦⣙⣛⣛⣵⡾⠯⠭⠭⠭⠭⠭⠭⠉⢙⡇⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⢠⣾⡛⠻⡿⣿⡿⠭⣽⡉⠭⠭⠭⠭⠭⠉⣉⠀⣸⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⢸⡟⣒⣸⠃⣿⠯⣽⡿⠭⠍⠉⠑⠒⠒⠐⠒⠀⡞⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⢸⡇⠐⠃⠥⣿⠨⡏⣏⣁⣀⣒⡒⠀⠀⠀⠀⠠⡇⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣻⡟⣾⣷⠡⠀⢈⣿⣕⣧⣗⡒⠀⠀⠤⠀⠠⠤⠀⣸⠃⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⢀⡴⠧⠭⣷⡏⢿⡷⠒⣿⣽⠿⣧⡧⠭⠯⠉⠉⣛⠒⠒⠂⡜⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⢀⡴⠯⢍⣉⡐⣻⣷⠢⠽⠿⠯⠍⣉⣿⣗⠒⠀⠠⠀⠤⠤⢁⣹⠃⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⢀⣴⣋⡓⠒⠂⠀⠄⢸⣿⣌⣓⠐⠒⠠⢤⣿⠇⣉⣉⡈⠒⠒⠂⢤⠃⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠠⢶⣣⣤⠤⢉⢀⡀⠐⠀⠂⠘⣿⡯⣍⣩⣴⣾⠟⠢⠤⠤⢌⣉⣉⣱⠃⠀⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠉⠉⠒⠒⠬⠭⠤⣒⣬⡭⠿⢛⣉⣁⠀⠒⠒⠠⠤⢄⠜⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠑⠒⠂⠭⠭⣒⣒⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

    public Ui() {
    }

    public String welcome() {
        String message =  "Hello from Clippy\n" + this.logo + "\nWhat can I do for you?";
        return wrapWithLines(message);
    }

    public String goodbye() {
        String message = "Bye. Hope to see you again soon!";
        return wrapWithLines(message);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showAdded(Task task, int total) {
        System.out.println("Got it. I've added this task:\n  " + task
                + "\nNow you have " + total + " tasks in the list.");
    }

    public void showDeleted(Task task, int total) {
        System.out.println("Noted. I've removed this task:\n" + task
                + "\nNow you have " + total + " tasks in the list.");
    }

    public void showMarked(Task task) {
        System.out.println("\nNice! I've marked this task as done:\n" + task);
    }

    public void showUnmarked(Task task) {
        System.out.println("\nOK, I've marked this task as not done yet:\n" + task);
    }

    public static String wrapWithLines(String message) {
        return horizontalLine + "\n" + message + "\n" + horizontalLine;
    }

    public void showLine() {
        System.out.println(horizontalLine);
    }

}