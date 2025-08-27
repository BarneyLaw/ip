public class Parser {

    public Parser() {
    }

    public static int parseIndex(String input, int listSize) throws ClippyException {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            throw new ClippyException("☹ OOPS!!! The index of a task cannot be empty.");
        }
        try {
            int index = Integer.parseInt(parts[1]) - 1;
            if (index < 0 || index >= listSize) {
                throw new ClippyException("☹ OOPS!!! The task index is out of bounds.");
            }
            return index;
        } catch (NumberFormatException e) {
            throw new ClippyException("☹ OOPS!!! The task index must be a valid integer.");
        }
    }
}
