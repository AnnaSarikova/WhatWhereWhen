package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendAnswerButton;

    @FXML
    private TextArea GameTextAreaQuestion;

    @FXML
    private TextArea GameTextAreaAnswer;

    @FXML
    private Button EndButton;

    @FXML
    void initialize() {
    }

    @FXML
    public void switchToGame(ActionEvent event) throws IOException {

        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Game.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }

    @FXML
    public void EndButtonAction(ActionEvent event) throws IOException{
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Account.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();
    }
}

