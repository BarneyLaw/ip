package clippy.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import clippy.ClippyException;
import clippy.task.DeadlineTask;
import clippy.task.EventTask;
import clippy.task.Task;
import clippy.task.ToDoTask;

public class Storage {
    private static final String DIR = "data";
    private static final String FILE_PATH = "data/tasks.txt";
    private final Path filePath;

    public Storage() {
        this.filePath = Paths.get(FILE_PATH);
        ensureFile();
    }

    private void ensureFile() {
        try {
            Path dirPath = Paths.get(DIR);
            if (Files.notExists(dirPath)) {
                Files.createDirectories(dirPath);
            }
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Error storing file: " + e.getMessage());
        }
    }

    public List<Task> load() {
        List<Task> tasks = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        } catch (ClippyException e) {
            System.out.println("Error parsing tasks: " + e.getMessage());
        }
        return tasks;
    }

    private Task parseTask(String line) throws ClippyException {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        switch (type) {
            case "T":
                Task todo = new ToDoTask(parts[2]);
                if (isDone) {
                    todo.markAsCompleted();
                }
                return todo;
            case "D":
                Task deadline = new DeadlineTask(parts[2], parts[3]);
                if (isDone) {
                    deadline.markAsCompleted();
                }
                return deadline;
            case "E":
                Task event = new EventTask(parts[2], parts[3], parts[4]);
                if (isDone) {
                    event.markAsCompleted();
                }
                return event;
            default:
                throw new ClippyException("Unknown task type in file.");
        }
    }

    public void save(List<Task> tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(serializeTask(task));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private String serializeTask(Task task) {
        String status = task.isCompleted() ? "1" : "0";
        if (task instanceof ToDoTask) {
            return "T | " + status + " | " + task.getDescription();
        } else if (task instanceof DeadlineTask) {
            return "D | " + status + " | " + task.getDescription() + " | "
                    + ((DeadlineTask) task).getBy().toStorageString();
        } else if (task instanceof EventTask) {
            return "E | " + status + " | " + task.getDescription() + " | "
                    + ((EventTask) task).getFrom() + " | " + ((EventTask) task).getTo();
        }
        return "";
    }
}
