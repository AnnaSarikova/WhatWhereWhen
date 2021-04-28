package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;

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
    private ImageView GifAction;
    @FXML
    private TextArea GameTextAreaAnswer;

    @FXML
    private Button EndButton;

    @FXML
    void initialize() {
        GameTextAreaQuestion.appendText("Hello");
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


    @FXML
    public void SendAnswerAction(ActionEvent event) throws IOException{
        String text = new String();
        text = GameTextAreaAnswer.getText();

    }
}

