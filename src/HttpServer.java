import java.util.logging.Logger;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class HttpServer {
    private static final int PORT = 4000;
    private static final Logger log = Logger.getLogger(HttpServer.class.getName());

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.start();
    }

    private HttpServer() {
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("Server started: Listening on port " + PORT + "....");
            while(true){
                Socket clientSocket = serverSocket.accept();
                log.info("Connection accepted: " + clientSocket);
            }
        } catch (IOException e) {
        }
    }
}
