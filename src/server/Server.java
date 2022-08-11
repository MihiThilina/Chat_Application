package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) throws IOException {
        Socket accept=null;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started!");
        accept = serverSocket.accept();
        System.out.println("Client Connected!");
        InputStreamReader inputStreamReader = new InputStreamReader(
                accept.getInputStream()
        );
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readLine = bufferedReader.readLine();
        System.out.println(readLine);
    }
}
