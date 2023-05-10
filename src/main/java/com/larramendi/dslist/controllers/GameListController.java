package com.larramendi.dslist.controllers;

import com.larramendi.dslist.dto.GameListDTO;
import com.larramendi.dslist.dto.GameMinDTO;
import com.larramendi.dslist.projections.GameMinProjection;
import com.larramendi.dslist.services.GameListService;
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
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> getAllGameLists() {
        List<GameListDTO> savedGameLists = gameListService.getAllGameLists();
        return new ResponseEntity<>(savedGameLists, HttpStatus.OK);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> getGamesByList(@PathVariable Long listId) {
        List<GameMinDTO> savedGameMinList = gameService.getGamesByList(listId);
        return new ResponseEntity<>(savedGameMinList, HttpStatus.OK);
    }
}
