package tdp.threadpool;

public class UserParser {

    public static User parseLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line cannot be null");
        }

        // Expected: userid=123, username=Momo
        String[] fields = line.trim().split(",", -1);

        if (fields.length != 2) {
            throw new IllegalArgumentException("Expected two fields");
        }

        String idField = fields[0];
        String nameField = fields[1].trim();

        if (!idField.startsWith("userid=") ||
            !nameField.startsWith("username=")) {
            throw new IllegalArgumentException("Invalid field names");
        }

        int id = Integer.parseInt(
            idField.substring("userid=".length())
        );

        String name = nameField.substring("username=".length()).trim();

        if (name.isEmpty() || name.contains("=")) {
            throw new IllegalArgumentException("Invalid username");
        }

        return new User(id, name);
    }
}