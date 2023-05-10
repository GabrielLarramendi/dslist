package com.larramendi.dslist.services;

import com.larramendi.dslist.dto.GameDTO;
import com.larramendi.dslist.dto.GameMinDTO;
import com.larramendi.dslist.entities.Game;
import com.larramendi.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllGames() {
        List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(GameMinDTO::new).toList();
    }


}
