package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {
    public AnchorPane loginPane;
    public TextField txtuserName;
    public Button btnLogin;
    private DialogPane dialog;
    static String userName;

    public void onClickLogin(ActionEvent actionEvent) throws IOException {
        userName=txtuserName.getText();
        if (userName.equals("")) {
//            new Alert(Alert.AlertType.WARNING, "Waradiii !..").showAndWait();
            Alert alert = new Alert(Alert.AlertType.WARNING,"Wraddiiiii");
            alert.showAndWait();
//            dialog =  alert.getDialogPane();
//            dialog.getStylesheets().add(getClass().getResource("Style.css").toString());
//            dialog.getStyleClass().add("dialog");
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
