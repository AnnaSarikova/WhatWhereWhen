package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpFirstName;

    @FXML
    private TextField SignUpSecondName;

    @FXML
    private TextField SignUpLoginfield;

    @FXML
    private CheckBox SignUpCheckboxFemail;

    @FXML
    private CheckBox SignUpCheckboxMail;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpPassword;

    @FXML
    void initialize() {

    }
}

