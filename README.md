# multi-echo-server-TCP
A simple multithreaded TCP server implementation in Java. The server listens for incoming client connections and echoes back the received messages. Each client connection is handled in a separate thread using a thread pool, allowing for concurrent communication with multiple clients.

## Features
- Supports multiple clients simultaneously using a cached thread pool.
- Echoes back messages received from clients.

## How to change port
To change the port where the server is listening on you have to change the default port number (1234).

```java
public static void main(String[] args) {
        MultiEchoServer echoServer = new MultiEchoServer(1234); //Port number
        echoServer.startServer();
    }
