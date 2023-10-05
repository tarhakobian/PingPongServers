import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpPingPongServer {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt("8080");
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Define an HTTP context and set a handler
        server.createContext("/ping", new HttpPingPongHandler());
        server.setExecutor(null); // Default executor

        server.start();
        System.out.println("HTTP Server started on port " + port);
    }
}

