import java.util.logging.Logger;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
                inputStream.read();
                log.info("Request read" + inputStream);
                outputStream.flush();
                serverSocket.setSoTimeout(10000);
                outputStream.close();
            }
        } catch (IOException e) {
            log.info("Error accpeting socket");
        }
    }
}
