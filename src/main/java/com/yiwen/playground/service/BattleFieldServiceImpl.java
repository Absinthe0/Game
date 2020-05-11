package com.yiwen.playground.service;

import com.yiwen.playground.persistence.entity.BattleField;
import com.yiwen.playground.persistence.repository.BattleFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BattleFieldServiceImpl implements BattleFieldService {

    @Autowired
    private final BattleFieldRepository battleFieldRepository;

    public BattleField saveOrUpdate(BattleField battleField) {
        return battleFieldRepository.saveAndFlush(battleField);
    }

    public BattleField findBattleFieldById(long id) {
        return battleFieldRepository.findById(id);
    }

    public List<BattleField> findAll() {
        return battleFieldRepository.findAll();
    }

    public List<BattleField> findBattleFieldByName(String name) {
        return battleFieldRepository.findByName(name);
    }

}
