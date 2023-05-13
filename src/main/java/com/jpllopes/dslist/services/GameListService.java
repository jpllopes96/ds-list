package com.jpllopes.dslist.services;

import com.jpllopes.dslist.dto.GameDTO;
import com.jpllopes.dslist.dto.GameListDTO;
import com.jpllopes.dslist.dto.GameMinDTO;
import com.jpllopes.dslist.entities.Game;
import com.jpllopes.dslist.entities.GameList;
import com.jpllopes.dslist.projections.GameMinProjection;
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

    @Autowired GameRepository gameRepository;

    @Transactional( readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional( readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i=0; i<= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }



}
