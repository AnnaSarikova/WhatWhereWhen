package sample.utils;
import com.google.gson.Gson;
import sample.model.Question;
import sample.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 *  a p i
 *  запросы отправляемые клиентом
 */
public class API {

    static String serverURL = "http://localhost:8081";
    private static final Gson gson = new Gson();

    /**
     * registration
     * регистрация пользователя в системе
     * @param first_name first_name
     * @param second_name second_name
     * @param email email
     * @param password password
     * @return {@link Map}
     * @see Map
     * @see String
     * @see Object
     */
    public static Map<String, Object> registration(String first_name, String second_name, String email, String password) {

        String URL = serverURL+"/registration";
        Map<String, String> params = new HashMap<>();
        params.put("first_name",first_name);
        params.put("second_name", second_name);
        params.put("email", email);
        params.put("password", password);
        String response = RequestUtil.sendPOST(URL, params);
        Map<String, Object> resultMap = new HashMap<>();
        return new HashMap<>() {{
            put("response", response);
        }};
    }


    /**
     * auth
     * авторизация пользователя через email и парроль
     * @param email email
     * @param password password
     * @return {@link User}
     * @see User
     */
    public static User auth(String email, String password) {
        String URL = serverURL+"/auth";
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        String userString = RequestUtil.sendPOST(  URL, params);
        System.out.println(userString);
        return gson.fromJson(userString, User.class);
    }

    /**
     * getquest
     * запрос на взятие вопроса из бд на сервере
     * @param id id
     * @return {@link Question}
     * @see Question
     */
    public static Question getquest(int id){

        String URL = serverURL + "/question";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        String questionString = RequestUtil.sendPOST(URL, params);
        return gson.fromJson(questionString, Question.class);

    }

    /**
     * checkansw
     * проверка ответа введенного пользователем
     * @param answer answer
     * @param id_question id_question
     * @param id id
     * @return {@link Map}
     * @see Map
     * @see String
     * @see String
     */
    public static Map<String,String> checkansw(String answer, String id_question, String id){
        String URL = serverURL + "/answer";
        Map<String, String> params = new HashMap<>();
        params.put("answer", answer);
        params.put("id_question",id_question);
        params.put("id", id);
        String answ = RequestUtil.sendPOST(URL, params);
        return new HashMap<>(){{
            put("answer",answ);
        }};



    }

    /**
     * rating
     * возвращает пользователю его рейтинг
     * @param score score
     * @return {@link Integer}
     * @see Integer
     */
    public static Integer rating( Long score){
        String URL = serverURL + "/rating";
        Map<String, String> params = new HashMap<>();
        params.put("score",String.valueOf(score));
        String ratString = RequestUtil.sendPOST(URL, params);
        System.out.println(ratString);
        return Integer.parseInt(ratString);

    }

    /**
     * checkupdate
     * обновляет баллы пользователя
     * @param id id
     * @param score score
     * @return {@link User}
     * @see User
     */
    public static User checkupdate(String id,String score){
        String URL = serverURL + "/updatescore";
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("score", score);
        String update = RequestUtil.sendPOST(URL, params);
        System.out.println(update);
        return gson.fromJson(update, User.class);

    }

}
