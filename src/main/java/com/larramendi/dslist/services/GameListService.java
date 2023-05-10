package com.larramendi.dslist.services;

import com.larramendi.dslist.dto.GameDTO;
import com.larramendi.dslist.dto.GameListDTO;
import com.larramendi.dslist.entities.Game;
import com.larramendi.dslist.entities.GameList;
import com.larramendi.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> getAllGameLists() {
        List<GameList> savedGameList = gameListRepository.findAll();
        return savedGameList.stream()
                .map(GameListDTO::new)
                .toList();
    }
}
