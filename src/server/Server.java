package server;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public  class Server {
//   public static Socket accept=null;

    private final ServerSocket serverSocket;

    private  static ArrayList<ClientHandler> clientHandlers=new ArrayList<>();

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket accept;

        while(true){
            System.out.println("Weiting for client");
            accept =serverSocket.accept();
            System.out.println("new member coNECTD");
            ClientHandler clientHandler=new ClientHandler(accept,clientHandlers);
            clientHandlers.add(clientHandler);
            clientHandler.start();

        }

    }

//    private void serverSocket() {
//        /* while(true){if(!message.equals("exit"))}*/
//        try {
//            while (!serverSocket.isClosed()) {
//                Socket socket = null;
//
//                socket = serverSocket.accept();
//
//                System.out.println("client has connectd");
//                ClientHandler clientHandler = new ClientHandler(socket);
//                Thread thread = new Thread(clientHandler);
//                thread.start();
//                System.out.println("Client awaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
