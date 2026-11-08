package tdp.threadpool;

import java.util.Map;

/**
 * 
 * BasicUserProcessor
 * 
 * You can assume that the input file has correct formatting
 */
public class BasicUserProcessor {

    // Shared by all worker tasks that use this processor instance.
    protected final Map<Integer, String> users = createUserMap();

    private static Map<Integer, String> createUserMap() {
        // TODO
        throw new UnsupportedOperationException("TODO: create thread-safe map");
    }

    public void processLine(String line) {
        // TODO
        throw new UnsupportedOperationException("TODO: process one valid line");
    }

    protected void storeUser(User user) {
        // TODO
        throw new UnsupportedOperationException("TODO: store user");
    }

    // Can be used for testing
    public Map<Integer, String> getUsers() {
        return Map.copyOf(users);
    }
}
