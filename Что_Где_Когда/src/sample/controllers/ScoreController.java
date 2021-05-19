package sample.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.User;
import sample.utils.API;

/**
 *  score controller
 *  контроллер для окна баллы
 */
public class ScoreController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextScore;

    @FXML
    private Button UpdateScore;

    @FXML
    private Button BackPage;

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
    /**
     *  update score action
     *
     * @param event event
     */
    @FXML
    void UpdateScoreAction(ActionEvent event) {
        TextScore.setText(String.valueOf(Main.getUser().getScore()));

        Long lastScore = Main.getUser().getScore();
        String id_user = String.valueOf(Main.getUser().getId());
        String score = String.valueOf(Main.getUser().getScore());
        User update = API.checkupdate(id_user,score);
        if (lastScore <= update.getScore()){
            TextScore.setText(String.valueOf(update.getScore()));
        }

    }

    @FXML
    void initialize() {

    }


}
