package clippy.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import clippy.ClippyException;

/**
 * Represents a date or date-time used in tasks.
 */
public class DateTime {
    private static final DateTimeFormatter DATE_TIME_INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter DATE_TIME_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
    private static final DateTimeFormatter DATE_INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy");
    private LocalDate date;
    private LocalDateTime dateTime;


    /**
     * Constructs a DateTime object from the given input string.
     * The input can be in the format "YYYY-MM-DD HHMM" for date and time,
     * or "YYYY-MM-DD" for date only.
     *
     * @param input The input string representing the date and time.
     * @throws ClippyException If the input format is invalid.
     */
    public DateTime(String input) throws ClippyException {
        try {
            this.date = LocalDate.parse(input, DATE_INPUT_FORMAT);
            assert this.date != null : "Parsed LocalDate should not be null";
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
