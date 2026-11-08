package tdp.threadpool;

import java.util.List;
import java.util.Queue;

// Stage 3
public class ValidatingUserProcessor extends DuplicateAwareUserProcessor {

    protected final Queue<String> errors = createErrorQueue();

    private static Queue<String> createErrorQueue() {
        // TODO
        throw new UnsupportedOperationException("TODO: create errors queue");
    }

    @Override
    public void processLine(String line) {
        // TODO
        throw new UnsupportedOperationException("TODO: reject invalid lines");
    }

    // For testing - not thread-safe
    public List<String> getErrors() {
        return List.copyOf(errors);
    }
}
