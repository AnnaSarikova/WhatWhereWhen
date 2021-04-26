package sample.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class SignUpController<TextField> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField PasswordField;

    @FXML
    private TextField SignUpFirstName;

    @FXML
    private TextField SignUpSecondName;

    @FXML
    private TextField LoginField;

    @FXML
    private CheckBox SignUpCheckboxFemail;

    @FXML
    private CheckBox SignUpCheckboxMail;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {

    }
}
