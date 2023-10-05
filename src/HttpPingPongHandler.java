import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class HttpPingPongHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Get the client's IP address
        String clientHost = exchange.getRemoteAddress().getAddress().getHostAddress();

        // Print a message indicating the receipt of "ping"
        System.out.println("Received from " + clientHost + ": Received ping");

        // Handle the "ping" request and send "pong" response
        String response = "pong";

        // Print a message indicating the "pong" response
        System.out.println("Sent pong to " + clientHost);

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
