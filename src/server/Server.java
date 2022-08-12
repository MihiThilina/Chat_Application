package server;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


public  class Server {
//   public static Socket accept=null;

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }



    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started!");
        Server server = new Server(serverSocket);
        server.serverSocket();

    }

    private void serverSocket() {
        /* while(true){if(!message.equals("exit"))}*/
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = null;

                socket = serverSocket.accept();

                System.out.println("client has connectd");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
                System.out.println("Client awaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
