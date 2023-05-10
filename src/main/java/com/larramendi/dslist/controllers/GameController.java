package com.larramendi.dslist.controllers;

import com.larramendi.dslist.dto.GameDTO;
import com.larramendi.dslist.dto.GameMinDTO;
import com.larramendi.dslist.entities.Game;
import com.larramendi.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id) {
        GameDTO savedGameDTO = gameService.findById(id);
        return new ResponseEntity<>(savedGameDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAllGames() {
        List<GameMinDTO> savedGamesList = gameService.getAllGames();
        return new ResponseEntity<>(savedGamesList, HttpStatus.OK);
    }
}
