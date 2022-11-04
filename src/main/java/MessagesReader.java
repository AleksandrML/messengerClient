import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessagesReader extends Thread {

    private BufferedReader in;

    public MessagesReader(Socket clientSocket) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        start(); // вызываем run()
    }

    @Override
    public void run() {
        String message;
        try {
            while (!isInterrupted()) {
                message = in.readLine(); // ждем сообщения с сервера
                System.out.println(message);
                Logger.write(message);
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        } catch (IOException e) {
        }
    }
}