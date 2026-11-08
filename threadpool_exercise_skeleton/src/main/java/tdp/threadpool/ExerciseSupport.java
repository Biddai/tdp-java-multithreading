package tdp.threadpool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Provided by us - do not change
public final class ExerciseSupport {
    private ExerciseSupport() {}

    public static List<String> readLines(Path file) throws IOException {
        return Files.readAllLines(file);
    }

    public static List<Runnable> createTasks(
            List<String> lines, BasicUserProcessor processor) {
        List<Runnable> tasks = new ArrayList<>(lines.size());
        for (String line : lines) {
            tasks.add(() -> processor.processLine(line));
        }
        return tasks;
    }
}
