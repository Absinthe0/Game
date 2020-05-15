package com.yiwen.playground.service;

import com.yiwen.playground.persistence.entity.Battle;
import com.yiwen.playground.persistence.repository.BattleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("battleService")
@RequiredArgsConstructor
public class BattleServiceImpl implements BattleService {

    @Autowired
    private BattleRepository battleRepository;

    public Battle saveOrUpdate(Battle battle) {
        return battleRepository.saveAndFlush(battle);
    }

    public List<Battle> findAll() {
        return battleRepository.findAll();
    }

    public Battle findById(long id) {
        return battleRepository.findById(id);
    }




}

