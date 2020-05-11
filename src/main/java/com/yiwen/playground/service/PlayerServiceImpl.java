package com.yiwen.playground.service;

import com.yiwen.playground.persistence.entity.Player;
import com.yiwen.playground.persistence.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findById(long id) {
        return playerRepository.findById(id);
    }

    public Player newPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    public List<Player> findByName(String firstName, String lastName) {
        return playerRepository.findByFirstNameAndLastName(firstName, lastName);
    }


}
