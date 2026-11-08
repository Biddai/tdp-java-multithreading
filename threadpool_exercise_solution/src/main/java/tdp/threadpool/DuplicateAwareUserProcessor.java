package tdp.threadpool;

import java.util.Map;

// OPTIONAL STAGE 2: all input is valid with correct formatting, but IDs may repeat.
public class DuplicateAwareUserProcessor extends BasicUserProcessor {
    
    private Map<Integer, String> dups = createUserMap();
 
    @Override
    protected void storeUser(User user) {
        // To prevent duplications we need to prevent the race condition on the userid
        // To do that we can use atomic insertion that is supported by the concurrentHashMap
        String prev = this.users.putIfAbsent(user.id(),user.name());
        if (prev != null && !prev.equals(user.name())){
            this.dups.put(user.id(),user.name());
        }
        
    }

    public Map<Integer, String> getDuplicateUsers(){
        return this.dups;
    }
}
