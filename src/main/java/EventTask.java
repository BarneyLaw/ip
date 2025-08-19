public class EventTask extends Task {
    private String from;
    private String to;

    public EventTask(String description, String from, String to) throws ClippyException {
        super(validateDescription(description));
        if (from == null || from.trim().isEmpty()) {
            throw new ClippyException("An event must have a starting time(use /from <time>)");
        }
        if (to == null || to.trim().isEmpty()) {
            throw new ClippyException("An event must have an ending time(use /to <time>).");
        }
        this.from = from;
        this.to = to;
    }

    private static String validateDescription(String description) throws ClippyException {
        if (description == null || description.trim().isEmpty()) {
            throw new ClippyException("Your event must have a description.");
        }
        return description;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}