
package tdp.threadpool;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ValidatingUserProcessor extends DuplicateAwareUserProcessor {

    protected final Queue<String> errors = createErrorQueue();

    private static Queue<String> createErrorQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    // Smart use of inherited methods and exceptions
    @Override
    public void processLine(String line) {
        try {
            super.processLine(line);
        } catch (IllegalArgumentException e) {
            errors.add(line);
            //Ideally should be printed to logs
            System.err.println("Invalid line: " + line +" Reason:" + e.getMessage());
        }
    }

    public List<String> getErrors() {
        return List.copyOf(errors);
    }
}
