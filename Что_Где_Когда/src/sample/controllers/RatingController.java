package sample.controllers;

import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.Main;
import sample.model.User;
import sample.utils.API;


import javax.security.auth.callback.Callback;

/**
 *  rating controller
 *  контроллер для окна рейтинг
 */
public class RatingController {
    User user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> RatingTable;
    @FXML
    private TableColumn<User,String> Firstname;
    @FXML
    private TableColumn<User,Integer> score;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField MyRating;


    /**
     *  back action
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    void BackAction(ActionEvent event) throws IOException {
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Account.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();

    }


    @FXML
    void initialize() {

    }

    @FXML
    protected void addUser(ActionEvent event){

    }


    /**
     *  update action
     *
     * @param event event
     */
    public void UpdateAction(ActionEvent event) {
        System.out.println("Rating");
        user = Main.getUser();
        Integer rat = API.rating(user.getScore());
        System.out.println(rat);
        MyRating.setText(String.valueOf(rat));

    }
}

