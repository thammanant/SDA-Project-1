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
        // TODO
        return "Not implemented";
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
