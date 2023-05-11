package com.jpllopes.dslist.services;

import com.jpllopes.dslist.dto.GameDTO;
import com.jpllopes.dslist.dto.GameListDTO;
import com.jpllopes.dslist.dto.GameMinDTO;
import com.jpllopes.dslist.entities.Game;
import com.jpllopes.dslist.entities.GameList;
import com.jpllopes.dslist.repositories.GameListRepository;
import com.jpllopes.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional( readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }




}
