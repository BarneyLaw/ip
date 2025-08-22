import java.util.Scanner;

public class Clippy {
    public static void main(String[] args) {
        Bot bot = new Bot();
        Scanner scanner = new Scanner(System.in);

        System.out.println(bot.greet());
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new ClippyException("Input cannot be empty. Please enter a command.");
                }
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
                        if (parts.length < 2) throw new ClippyException("Please specify which task to mark.");
                        int idx = Integer.parseInt(parts[1].trim());
                        bot.markTask(idx);
                        break;
                    case "unmark":
                        if (parts.length < 2) throw new ClippyException("Please specify which task to unmark.");
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
                    case "delete":
                        bot.deleteTask(parts.length > 1 ? parts[1].trim() : "");
                        break;
                    default:
                        throw new ClippyException("Sorry, I don't understand that command.");
                }
            } catch (ClippyException e) {
                System.out.println("______________________________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("______________________________________________________________________________");
            } catch (NumberFormatException e) {
                System.out.println("______________________________________________________________________________");
                System.out.println("Please enter a valid number for task index.");
                System.out.println("______________________________________________________________________________");
            } catch (Exception e) {
                System.out.println("______________________________________________________________________________");
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("______________________________________________________________________________");
            }
        }

    }
}
