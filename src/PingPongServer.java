import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket that listens on the port passed as the command line argument
        try (ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]))) {
            // Print out a message indicating that the server is listening on the given port
            System.out.println("Server listening on port " + args[0]);

            // Loop infinitely to accept client connections
            while (true) {
                // Wait for a client to connect and accept the connection
                Socket s = ss.accept();

                // Print out the IP address of the client that just connected
                System.out.println("Client connected from " + s.getInetAddress());

                // Create a new PingPongHandler object to handle the communication with the client
                PingPongHandler handler = new PingPongHandler(s);

                // Run the PingPongHandler object's run() method to handle the communication with the client
                handler.run();
            }
        }
    }
}
