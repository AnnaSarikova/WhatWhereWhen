package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.User;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Main.user = user;
    }
    private static User[] users;
    public static User[] getUsers() {
        return users;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        primaryStage.setTitle("WhatWhereWhen");


        showSignUpOverview();

        primaryStage.show();

    }

    /**
     * show sign up overview
     * вызов окна регистрация
     * @throws IOException java.io. i o exception
     */
    public void showSignUpOverview() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
        Scene signUpScene = new Scene(root);
        primaryStage.setScene(signUpScene);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
