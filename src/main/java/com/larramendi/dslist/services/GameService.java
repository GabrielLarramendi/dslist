package com.larramendi.dslist.services;

import com.larramendi.dslist.dto.GameMinDTO;
import com.larramendi.dslist.entities.Game;
import com.larramendi.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> getAllGames() {
        List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(GameMinDTO::new).toList();
    }
}
