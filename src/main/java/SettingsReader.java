import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SettingsReader {

    private static final String settingsFileName = "settings.txt";

    public static int readPort() {
        try(BufferedReader br = new BufferedReader(new FileReader(settingsFileName))) {
            String line = br.readLine();

            while (line != null) {
                if (line.contains("port:")) {
                    line = line.replace("port:", "").strip();
                    return Integer.parseInt(line);
                }
                line = br.readLine();
            }
            System.out.println("add port number as 'port: int_number' to settings.txt file");
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readIp() {
        try(BufferedReader br = new BufferedReader(new FileReader(settingsFileName))) {
            String line = br.readLine();

            while (line != null) {
                if (line.contains("ip:")) {
                    line = line.replace("ip:", "").strip();
                    return line;
                }
                line = br.readLine();
            }
            System.out.println("add ip path as 'ip: ip_string' to settings.txt file");
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
