package tdp.threadpool;

// Stage 2
public class DuplicateAwareUserProcessor extends BasicUserProcessor {

    @Override
    protected void storeUser(User user) {
        // TODO
        // NOTE: first successful insertion wins, not first file occurrence.
        throw new UnsupportedOperationException("TODO: handle duplicate IDs");
    }
}
