package tdp.threadpool;

import java.nio.file.Path;
import java.util.List;

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
        // Prints valid entries stats
        System.out.println("Distinct users: " + processor.getUsers().size());
        //Transforms the map into a streamable set
        processor.getUsers().entrySet().stream().limit(10)
                .forEach(System.out::println);

        // TODO Prints duplicates
        
        // TODO Prints invalids

    }

    static void runTasks(List<Runnable> tasks) throws Exception {
        // TODO
        throw new UnsupportedOperationException("TODO: configure and run the thread pool");
    }
}
