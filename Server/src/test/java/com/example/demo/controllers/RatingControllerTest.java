package com.example.demo.controllers;

import com.example.demo.ServerApplication;
import com.example.demo.repo.AnswerRepository;
import com.example.demo.repo.QuestionRepository;
import com.example.demo.repo.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ServerApplication.class
)
@AutoConfigureMockMvc

class RatingControllerTest {

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
     * rating writing all users and send it to client
     *
     * @throws JSONException org.json. j s o n exception
     */
    @Test
    void rat() throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("баллы",2L);
            this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8081/answer")
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