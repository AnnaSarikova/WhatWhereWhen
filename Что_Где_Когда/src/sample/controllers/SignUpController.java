package sample.controllers;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TextField SignUpCity;


    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpPassword;

    @FXML
    void initialize() {

    }


    @FXML
    public void SignUpAction(ActionEvent event) throws IOException {
        if (!SignUpFirstName.getText().isBlank() && !SignUpSecondName.getText().isBlank() &&
                !SignUpLoginfield.getText().isBlank() && !SignUpCity.getText().isBlank() &&
                !SignUpPassword.getText().isBlank()){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene((FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/Account.fxml")))));


        }

    }


    public void SignUpAction(javafx.event.ActionEvent actionEvent) throws IOException {
        if (!SignUpFirstName.getText().isBlank() && !SignUpSecondName.getText().isBlank() &&
                !SignUpLoginfield.getText().isBlank() && !SignUpCity.getText().isBlank() &&
                !SignUpPassword.getText().isBlank()){
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene((FXMLLoader.load((getClass().getResource("/views/Account.fxml")))));
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();


        }
    }
}

