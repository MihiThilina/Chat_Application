package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginPane;
    public TextField txtuserName;
    public Button btnLogin;

    static String userName;

    public void onClickLogin(ActionEvent actionEvent) throws IOException {
        userName=txtuserName.getText();
        if (userName.equals("")) {
            new Alert(Alert.AlertType.WARNING, "Waradiii Hu**oooo!..").showAndWait();
        }else {
            Stage stage = (Stage) txtuserName.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/ChatDashBoardForm.fxml"))));
            stage1.setResizable(false);
            stage1.setTitle(userName);
            stage1.centerOnScreen();
            stage1.show();
        }
    }

    public void onclickUseName(ActionEvent actionEvent) {
    }
}
