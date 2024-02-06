import java.io.FileWriter;
import java.io.IOException;

public class WriteToLog {
    private final String logFile = "log.txt";

    // Write
    public void write(String message) {
        try {
            FileWriter writer = new FileWriter(logFile, true);
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read
    public String read() {
        try {
            return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(logFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Clear
    public void clear() {
        try {
            FileWriter writer = new FileWriter(logFile);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
