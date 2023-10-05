import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class PingPongClient {
    public static void main(String[] args) {
        // Check if the required arguments are passed
        if (args.length < 1) {
            System.err.println("Usage: java PingPongClient <server-hostname>");
            System.exit(1);
        }

        // Extract the server hostname from the arguments
        String serverHostname = args[0];

        try (
                // Create a socket to connect to the server and open input and output streams
                Socket s = new Socket(serverHostname, Integer.parseInt(args[1]));
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true)
        ) {
            // Loop infinitely
            while (true) {
                // Wait for ping message from server
                String message = in.readLine();

                // If message is null, break from the loop
                if (message == null) {
                    break;
                }
                // If message is "ping", send "pong" message to the server
                else if ("ping".equals(message)) {
                    System.out.println("Received ping from server");
                    out.println("pong");
                    System.out.println("Sent pong to server" + serverHostname);
                }
                // Otherwise, print an error message
                else {
                    System.err.println("Invalid message from server " + serverHostname + ": " + message);
                }

                // Sleep for a second
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            // If there is an exception, print an error message
            System.err.println("Error communicating with server " + serverHostname + ": " + e.getMessage());
        }
    }
}