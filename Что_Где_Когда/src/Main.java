import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        primaryStage.setTitle("WhatWhereWhen");

        //showAccountOverview();

        showSignInOverview();

        //showSignUpOverview();

        primaryStage.show();

    }

    public void showSignUpOverview() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
        Scene signUpScene = new Scene(root);
        primaryStage.setScene(signUpScene);

    }

    public void showSignInOverview() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/SignIn.fxml"));
        Scene signInScene = new Scene(root);
        primaryStage.setScene(signInScene);
    }

    public void showAccountOverview() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Account.fxml"));
        Scene accountScene = new Scene(root);
        primaryStage.setScene(accountScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
