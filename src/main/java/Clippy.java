import java.util.Scanner;

public class Clippy {
    public static void main(String[] args) {
        Bot bot = new Bot();
        Scanner scanner = new Scanner(System.in);

        System.out.println(bot.greet());
        while (true) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "bye":
                    System.out.println(bot.bye());
                    scanner.close();
                    return;
                case "list":
                    System.out.println(bot.line() + bot.listToString() + bot.line());
                    break;
                case "mark":
                    int idx = Integer.parseInt(parts[1].trim());
                    bot.markTask(idx);
                    break;
                case "unmark":
                    int index = Integer.parseInt(parts[1].trim());
                    bot.unmarkTask(index);
                    break;
                case "todo":
                    bot.addToDo(parts.length > 1 ? parts[1].trim() : "");
                    break;
                case "deadline":
                    bot.addDeadline(parts.length > 1 ? parts[1].trim() : "");
                    break;
                case "event":
                    bot.addEvent(parts.length > 1 ? parts[1].trim() : "");
                    break;
                default:
                    bot.addToList(input);
                    System.out.println(bot.line() + "Added: " + input + "\n" + bot.line());
                    break;
            }
        }

    }
}
