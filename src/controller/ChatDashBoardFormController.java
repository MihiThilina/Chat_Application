package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import server.Server;

import java.io.IOException;

public class ChatDashBoardFormController {
    public AnchorPane chatRoomPane;
    public TextArea chatBoard;
    public TextField txtSend;
    public Button btnSend;



    public  static void run() throws IOException {
        Server.accept.close();
    }


    public void initialize(){

    }


    public void onClickSendMassage(ActionEvent actionEvent) {
    }

    public void onClickBtnSend(ActionEvent actionEvent) {
    }
}
