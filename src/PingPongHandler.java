import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class PingPongHandler implements Runnable {

    private final Socket s;
    private final BufferedReader in;
    private final PrintWriter out;

    public PingPongHandler(Socket clientSocket) throws IOException {
        // Initialize the socket and input/output streams
        this.s = clientSocket;
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Send ping message to client
                out.println("ping");
                System.out.println("Sent ping to client " + s.getInetAddress());

                // Wait for pong message from client
                String response = in.readLine();
                if (response == null) {
                    break;
                } else if ("pong".equals(response)) {
                    System.out.println("Received pong from client " + s.getInetAddress());
                } else {
                    System.err.println("Invalid response from client " + s.getInetAddress() + ": " + response);
                }

                // Sleep for ping interval
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error handling client " + s.getInetAddress() + ": " + e.getMessage());
        } finally {
            try {
                // Close the socket when finished
                s.close();
                System.out.println("Client " + s.getInetAddress() + " disconnected");
            } catch (IOException e) {
                System.err.println("Error closing client socket " + s.getInetAddress() + ": " + e.getMessage());
            }
        }
    }
}
