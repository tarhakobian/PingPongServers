# Java Ping Pong Application

Socket and Http based Ping Pong applications in Java, 
consisting of a server and client, that demonstrates
a basic client-server interaction via TCP/IP and HTTP.

## Overview

This Socket and HTTP based Java Ping Pong applications comprise a server and client component, demonstrating a basic client-server interaction where the server sends "ping" messages, and the client responds with "pong." The interaction continues until the client disconnects, making it a simple example to understand network communication in Java.

## Project Structure

The project consists of the following Java files:

1. **PingPongHandler.java**: The Socket server's handler class that manages client connections and communication.

2. **PingPongServer.java**: The Socket server application, which listens for incoming connections and delegates communication to `PingPongHandler`.

3. **PingPongClient.java**: The Socket client application, which connects to the server and responds to "ping" messages with "pong."

4. **HttpPingPongHandler.java**: The HTTP server's handler class that manages client connections and communication.

5. **HttpPingPongServer.java** The HTTP server application, which listens for incoming connections and delegates communication to `HttpPingPongHandler`.

6. **HttpPingPongClient.java**: The HTTP client application, which connects to the server and responds to "ping" messages with "pong."