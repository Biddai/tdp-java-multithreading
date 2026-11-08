package tdp.threadpool;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java ... Main <basic|duplicates|validating> <input-file>");
            System.exit(2);
        }

        // Choosing which processor to use 
        BasicUserProcessor processor = switch (args[0]) {
            case "basic" -> new BasicUserProcessor();
            case "duplicates" -> new DuplicateAwareUserProcessor();
            case "validating" -> new ValidatingUserProcessor();
            default -> throw new IllegalArgumentException("Unknown stage: " + args[0]);
        };

        List<String> lines = ExerciseSupport.readLines(Path.of(args[1]));
        List<Runnable> tasks = ExerciseSupport.createTasks(lines, processor);

        runTasks(tasks);

        System.out.println("Distinct users: " + processor.getUsers().size());
        //Transforms the map into a streamable set
        processor.getUsers().entrySet().stream().limit(10)
                .forEach(System.out::println);

        // Prints duplicates
        if (processor instanceof DuplicateAwareUserProcessor dupAware) {
            System.out.println("Malformed lines: " + dupAware.getDuplicateUsers().size());

            dupAware.getDuplicateUsers().entrySet().stream().limit(10)
                    .forEach(line -> System.out.println("  Duplicates: " + line));
        }
        // Prints invalid lines
        if (processor instanceof ValidatingUserProcessor validating) {
            System.out.println("Malformed lines: " + validating.getErrors().size());
            validating.getErrors().stream().limit(10)
                    .forEach(line -> System.out.println("  Invalid: " + line));
        }
    }

    static void runTasks(List<Runnable> tasks) throws Exception {

        // Creating a new executorService
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Runnable task : tasks){
            executor.submit(task);
        }
        // Closes the executor - prevents adding new tasks
        executor.shutdown();
        // wait for all tasks to finish
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

    }
}
