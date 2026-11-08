package tdp.threadpool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * BasicUserProcessor
 * 
 * You can assume that the input file has correct formatting
 */
public class BasicUserProcessor {

    // Shared by all worker tasks that use this processor instance.
    protected final Map<Integer, String> users = createUserMap();

    protected static Map<Integer, String> createUserMap() {
        return new ConcurrentHashMap<Integer, String>();
    }

    public void processLine(String line) {
        //Use the parser, get a user and submit it
        User user = UserParser.parseLine(line);
        storeUser(user);
    }

    protected void storeUser(User user) {
        this.users.put(user.id(),user.name());
    }

    // Can be used for testing
    public Map<Integer, String> getUsers() {
        return Map.copyOf(users);
    }
}
