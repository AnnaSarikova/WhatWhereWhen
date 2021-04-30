package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.utils.API;

public class SignInController<Gson> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignInButton;

    @FXML
    private TextField SignInloginfield;

    @FXML
    private PasswordField SgnInPassword;

    @FXML
    private Button SignUpButton;

    @FXML
    private Label LabelPassword;

    @FXML
    void initialize(URL url, ResourceBundle resources) {
    }

    @FXML
    public void switchToSignUp(ActionEvent event) throws IOException {
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }


    public void SignInAction(ActionEvent actionEvent) throws IOException {

        if (!SignInloginfield.getText().isBlank() && !SgnInPassword.getText().isBlank()) {
            String email = SignInloginfield.getText();
            String password = SgnInPassword.getText();
            Main.setUser(API.auth(email, password));
            System.out.println(Main.getUser().getId());

            if (Main.getUser() == null) {
                LabelPassword.setText("Неправильный email или пароль");
            }
            else{
                Node node = (Node) actionEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                Scene scene = new Scene((FXMLLoader.load((getClass().getResource("/views/Account.fxml")))));
                Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
            }
        }
        else {
            LabelPassword.setText("Не все поля заполнены");
        }
    }
}



