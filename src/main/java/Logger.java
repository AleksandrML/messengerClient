import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    public static void write(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Main.logFileName, true))) {
            String text = getLoggerMessage(message);
            bw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected static String getLoggerMessage(String message) {
        return LocalDateTime.now() + "; " + message + "\n";
    }
}
