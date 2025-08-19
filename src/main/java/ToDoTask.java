public class ToDoTask extends Task {
    public ToDoTask(String description) throws ClippyException {
        super(validateDescription(description));
    }

    private static String validateDescription(String description) throws ClippyException {
        if (description == null || description.trim().isEmpty()) {
            throw new ClippyException("A todo task must have a description.");
        }
        return description;
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}