package com.yiwen.playground.service;

import com.yiwen.playground.persistence.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> findAll();
    Player findById(long id);
    List<Player> findByName(String firstName, String lastName);
    List<Player> findByFirstName(String firstName);
    List<Player> findByLastName(String firstName);
    Player newPlayer(Player player);
}
