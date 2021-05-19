package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *  account controller
 *  контроллер окна аккаунт где распалагаются все активные кнопки
 */
public class AccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ScoresButton;

    @FXML
    private Button AboutUsButton;

    @FXML
    private Button RulesButton;

    @FXML
    private Button RatingButton;

    @FXML
    private Button PlayButton;

    @FXML
    void initialize() {
    }

    /**
     * switch to rules
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void switchToRules(ActionEvent event) throws IOException {
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Rules.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }

    /**
     * switch to about us
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void switchToAboutUs(ActionEvent event) throws IOException {
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/AboutUs.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }

    /**
     * switch to game
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void switchToGame(ActionEvent event) throws IOException {
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Game.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }

    /**
     *  score action
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void ScoreAction(ActionEvent event) throws IOException{
        Parent enter_page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/Score.fxml")));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }

    /**
     *  go to rating
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void GoToRating(ActionEvent event) throws IOException{
        Parent enter_page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/Rating.fxml")));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();
    }


}
