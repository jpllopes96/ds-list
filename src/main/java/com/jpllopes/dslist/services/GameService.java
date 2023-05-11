package com.jpllopes.dslist.services;

import com.jpllopes.dslist.dto.GameDTO;
import com.jpllopes.dslist.dto.GameMinDTO;
import com.jpllopes.dslist.entities.Game;
import com.jpllopes.dslist.projections.GameMinProjection;
import com.jpllopes.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional( readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional( readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto  = new GameDTO(result);
        return dto;
    }

    @Transactional( readOnly = true)
    public List<GameMinDTO> findByList(Long id){
        List<GameMinProjection> result = gameRepository.searchByList(id);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }


}
