public class DeadlineTask extends Task {
    private String by;

    public DeadlineTask(String description, String by) throws ClippyException {
        super(validateDescription(description));
        if (by == null || by.trim().isEmpty()) {
            throw new ClippyException("A deadline must have a set deadline(use '/by <deadline time'>).");
        }
        this.by = by;
    }

    private static String validateDescription(String description) throws ClippyException {
        if (description == null || description.trim().isEmpty()) {
            throw new ClippyException("A deadline task must have a description.");
        }
        return description;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + by + ")";
    }
}