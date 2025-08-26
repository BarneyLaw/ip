import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTime {
    private LocalDate date;
    private LocalDateTime dateTime;
    private static final DateTimeFormatter DATE_TIME_INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter DATE_TIME_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
    private static final DateTimeFormatter DATE_INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy");


    public DateTime(String input) throws ClippyException {
        try {
            this.date = LocalDate.parse(input, DATE_INPUT_FORMAT);
        } catch (DateTimeParseException e) {
           throw new ClippyException("Invalid date format. Please use YYYY-MM-DD (e.g. 2025-10-15).");
        }
    }

    @Override
    public String toString() {
        return date.format(DATE_OUTPUT_FORMAT);
    }

    public String toStorageString() {
        return date.format(DATE_INPUT_FORMAT);
    }
}
