package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GameController {

    /*
    @Autowired
    private GameRepository gameRepository;
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value = "/game")
    public ResponseEntity<Game> read(@RequestBody Map<String,String>  data ) {

        GameService gameService = new GameService(gameRepository);
        Game game = gameService.game();
        return game != null
                ? new ResponseEntity<>(game, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     */
}
