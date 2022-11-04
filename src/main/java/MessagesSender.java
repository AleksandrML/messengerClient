import java.io.*;
import java.util.Scanner;

public class MessagesSender extends Thread {

    private PrintWriter out;

    public MessagesSender(PrintWriter out) {
        this.out = out;
        start(); // вызываем run()
    }

    @Override
    public void run() {
        System.out.println("Вы подключены, можете отправлять сообщения из консоли. После ввода нажимайте enter. " +
                "Для завершения подключения введите '/exit'");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userMessage;
            userMessage = scanner.nextLine(); // сообщения с консоли
            if (userMessage.equals("/exit")) {
                out.println("/exit");
                break;
            } else {
                out.println(userMessage); // отправляем на сервер
            }
        }
    }
}
