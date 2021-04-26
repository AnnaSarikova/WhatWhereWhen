package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
    void initialize() {

    }
}

