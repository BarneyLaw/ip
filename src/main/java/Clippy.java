import java.util.Scanner;

public class Clippy {
    public static void main(String[] args) {
        Bot bot = new Bot();
        Scanner scanner = new Scanner(System.in);

        System.out.println(bot.greet());
        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.trim().equalsIgnoreCase("bye")) {
                System.out.println(bot.bye());
                break;
            } else {
                // add more personalized responses here
                System.out.println(bot.line() + userInput + "\n" + bot.line());
            }
        }
        scanner.close();
    }
}
