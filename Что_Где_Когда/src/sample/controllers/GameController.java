package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Question;
import sample.utils.API;

import javax.swing.text.html.ImageView;

/**
 *  game controller
 *  контроллер для окна игры
 */
public class GameController {

    private Question question;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendAnswerButton;

    @FXML
    private TextArea GameTextAreaQuestion;

    @FXML
    private ImageView GifAction;
    @FXML
    private TextArea GameTextAreaAnswer;

    @FXML
    private Button EndButton;

    @FXML
    private Button ShowQuestion;

    @FXML
    void initialize() {
    }

    /**
     * switch to game
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void switchToGame(ActionEvent event) throws IOException {
        if (GameTextAreaAnswer != null) {

            String answer = GameTextAreaAnswer.getText();
            String id_question = String.valueOf(question.getId());

            System.out.println(id_question);
            System.out.println(Main.getUser().getId());
            Long id_user = Main.getUser().getId();
            System.out.println(id_user);
            Map<String, String> checkanswer = API.checkansw(answer,id_question,String.valueOf(Main.getUser().getId()));
            if (!checkanswer.isEmpty()) {
                Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Game.fxml"));
                Scene enter_page_scene = new Scene(enter_page);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(enter_page_scene);
                app_stage.show();
            }
        }
    }

    /**
     *  end button action
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void EndButtonAction(ActionEvent event) throws IOException{
        Parent enter_page = FXMLLoader.load(getClass().getResource("/views/Account.fxml"));
        Scene enter_page_scene = new Scene(enter_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(enter_page_scene);
        app_stage.show();
    }



    /**
     *  show question action
     *
     * @param event event
     * @throws IOException java.io. i o exception
     */
    @FXML
    public void ShowQuestionAction(ActionEvent event) throws IOException{

        int id = random(3,1);
        this.question = API.getquest(id);
        question.setId(id);


        GameTextAreaQuestion.setText(question.getQuestions());

    }
    public int random(int max, int min){
        max-=min;
        return (int)(Math.random()*++max)+min;
    }
}

