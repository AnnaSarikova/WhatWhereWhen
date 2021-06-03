package com.example.demo.controllers;

import com.example.demo.ServerApplication;
import com.example.demo.models.User;
import com.example.demo.repo.AnswerRepository;
import com.example.demo.repo.QuestionRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ServerApplication.class
)
@AutoConfigureMockMvc

public class AnswerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp(){
        System.out.println("Initial setup...");
        System.out.println("Code executes only once");
    }



    /**
     * answer checking
     *
     * @throws JSONException org.json. j s o n exception
     */
    @Test
    void answ() throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("скорость",1L);
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
    @AfterClass
    public void afterMethod(){
        System.out.println("Test finished");
    }
}