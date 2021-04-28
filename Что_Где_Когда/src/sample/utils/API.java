package sample.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class API {

    static String serverURL = "http://localhost:8081";


    /**
     * Регистрация пользователя в системе
     *
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
     * Авторизация пользователя в системе
     * с помощью пары логин-пароль
     *
     * @param email    - логин пользователя
     * @param password - пароль пользоваетля
     * @return boolean
     */
    public static Map<String, Object> auth(String email, String password) {

        String URL = serverURL+"/auth";
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        String user = RequestUtil.sendPOST(URL, params);
        Map<String, Object> resultMap = new HashMap<>();
        return new HashMap<>() {{
            put("user", user );
        }};
    }



}
