package sample.controllers;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.utils.API;

import javax.swing.*;

public class SignUpController {

    @FXML
    private URL location;

    @FXML
    private TextField SignUpFirstName;

    @FXML
    private TextField SignUpSecondName;

    @FXML
    private TextField SignUpLoginfield;


    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpPassword;

    @FXML
    void initialize() {

    }

    @FXML
    public void SignUpAction(Event event) throws IOException {
        if (!SignUpFirstName.getText().isBlank() && !SignUpSecondName.getText().isBlank() &&
                !SignUpLoginfield.getText().isBlank()  &&
                !SignUpPassword.getText().isBlank()) {
            String first_name = SignUpFirstName.getText();
            String second_name = SignUpSecondName.getText();
            String email = SignUpLoginfield.getText();
            String password = SignUpPassword.getText();
            Map<String, Object> regResult = API.registration(first_name, second_name, email, password);


            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene((FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/SignIn.fxml")))));

        }

    }

}

