import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpPingPongClient {
    public static void main(String[] args) throws IOException {
        String serverUrl = "http://" + "127.0.0.1" + ":" + "8080" + "/ping"; // Server's URL
        URL url = new URL(serverUrl);
        while (true) {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try {
                InputStream responseStream = connection.getInputStream();
                Scanner scanner = new Scanner(responseStream);

                if (scanner.hasNextLine()) {
                    System.out.println("Sent ping");
                    String response = scanner.nextLine();
                    System.out.println("Received: " + response);
                }
            } finally {
                connection.disconnect();
            }

            // Sleep for a second before sending the next "ping" request
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
