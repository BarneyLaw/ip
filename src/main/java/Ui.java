public class Ui {
    private final String horizontalLine = "___________________________________________________________________________";
    private String logo = "⠀⠀⠀⠀⠀⠀  ⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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

    public String wrapWithLines(String message) {
        return horizontalLine + "\n" + message + "\n" + horizontalLine;
    }

    public String showLine() {
        return horizontalLine;
    }

}