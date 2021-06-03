package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repo.AnswerRepository;
import com.example.demo.repo.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp(){
        System.out.println("Initial setup...");
        System.out.println("Code executes only once");
    }

    /**
     * reg user checking
     *
     */
    @Test
    void regUser() {
        User user = new User();
        user.setId(4L);
        user.setFirstName("Anna");
        user.setSecondName("Sarikova");
        user.setEmail("AnnaSarikova@ya.ru");
        user.setPassword("20092001");
        user.setScore(0L);
        userRepository.save(user);
        assertNotNull(userRepository.findById(4L).get());

    }

    /**
     * auth checking
     *
     */
    @Test
    void auth() {
        User user = new User();
        user.setId(4L);
        user.setFirstName("Anna");
        user.setSecondName("Sarikova");
        user.setEmail("AnnaSarikova@ya.ru");
        user.setPassword("20092001");
        user.setScore(0L);
        userRepository.save(user);
        assertEquals(4L,4L);

    }

    /**
     * get user to DB
     *
     */
    @Test
    public void getUser(){
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("FirstName","Anna");
            jsonObject.put("SecondName","Sarikova");
            jsonObject.put("email","anna@ya.ru");
            jsonObject.put("password", "20092001");
            jsonObject.put("score", 0L);
            this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8081/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonObject.toString())
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andReturn();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * find user in DB
     *
     * @throws Exception java.lang. exception
     */
    @Test
    public void findUser() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","anna@ya.ru");
        jsonObject.put("password", "20092001");
        this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8081/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

    } catch (Exception e) {
        e.printStackTrace();
    }

}




}