package controller;

import javafx.event.ActionEvent;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;


public class ChatDashBoardFormController extends Thread{
    public AnchorPane chatRoomPane;
    public TextArea chatBoard;
    public TextField txtSend;
    public ScrollPane scrlPane;
    public VBox vBox;
    public TextField txtMassage;
    public Label lblName;
    public TextArea msgRoom;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public void initialize(){
        lblName.setText(LoginFormController.userName);
        connectSocket();
    }

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 8000);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run(){
        try {
            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split("");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fulmsg = new StringBuilder();
                for(int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println(fulmsg);
                if (cmd.equalsIgnoreCase(LoginFormController.userName + ":")) {
                    continue;
                } else if(fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                msgRoom.appendText(msg + "\n");
            }
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void send() {
        String msg = txtMassage.getText();
        writer.println(LoginFormController.userName + ": " + msg);
        msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        msgRoom.appendText("Me: " + msg + "\n");
        txtMassage.setText("");
        if(msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }
    }




    public void onClickSendMassage(MouseEvent mouseEvent) {
    }

    public void btnSendOnAction(ActionEvent actionEvent) {
        send();
    }



}
