package com.jpllopes.dslist.repositories;

import com.jpllopes.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
