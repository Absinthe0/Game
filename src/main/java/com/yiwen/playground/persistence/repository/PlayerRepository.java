package com.yiwen.playground.persistence.repository;

import com.yiwen.playground.persistence.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAll();
    Player findById(long id);
    List<Player> findByFirstNameAndLastName(String firstName, String lastName);
    Player saveAndFlush(Player player);

}
