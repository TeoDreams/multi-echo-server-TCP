import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiEchoServer {
    private int port;

    public MultiEchoServer(int port) {
        this.port = port;
    }

    public void startServer() {
        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println("Server is listening on port " + port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executor.submit(new EchoServerClientHandler(socket));
            } catch (IOException e) {
                break;
            }
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        MultiEchoServer echoServer = new MultiEchoServer(1234); //Port number
        echoServer.startServer();
    }
}