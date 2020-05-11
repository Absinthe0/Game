package com.yiwen.playground.service;

import com.yiwen.playground.persistence.entity.BattleField;

import java.util.List;
import java.util.Optional;

public interface BattleFieldService {

    BattleField saveOrUpdate(BattleField battleField);
    List<BattleField> findAll();
    BattleField findBattleFieldById(long id);
    List<BattleField> findBattleFieldByName(String name);

}
