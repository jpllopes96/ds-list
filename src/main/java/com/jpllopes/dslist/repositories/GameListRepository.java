package com.jpllopes.dslist.repositories;

import com.jpllopes.dslist.entities.GameList;
import com.jpllopes.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameListRepository extends JpaRepository <GameList, Long> {


}
