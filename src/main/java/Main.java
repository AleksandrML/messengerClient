import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static final String logFileName = "logs.log";
    public static final int PORT = SettingsReader.readPort();
    public static final String IP = SettingsReader.readIp();

    public static void main(String[] args) throws IOException {
        String host = IP;
        int port = PORT;
        String clientName = getChatName();
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("name:" + clientName);
            String resp = in.readLine();
            if (resp.contains("you're connected")) {
                // здесь должно быть два треда - постоянно выводящий новые сообщения юзеров и отправляющий сообщения текущего юзера
                Thread sender = new MessagesSender(out);
                Thread reader = new MessagesReader(clientSocket);
                while (true) {
                    if (!sender.isAlive()) {
                        reader.interrupt();
                        break;
                    }
                }
            }
        }

    }

    public static String getChatName() {
        System.out.println("Введите ваше имя для подключения в чат и нажмите enter: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.strip();
    }

}
