package socket.Multi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Twikura
 * @create 2019/3/8 8:36
 */
public class EchoMultiServer {
    private ServerSocket serverSocket;

    public void start (int port) throws Exception {
        serverSocket = new ServerSocket(port);
        while (true)
            new EchoClientHandler(serverSocket.accept()).start();
    }

    public void stop () throws Exception {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler (Socket socket) {
            this.clientSocket = socket;
        }

        public void run () {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args) throws Exception{
        EchoMultiServer echoMultiServer = new EchoMultiServer();
        echoMultiServer.start(5555);
    }
}