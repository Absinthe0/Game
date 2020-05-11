package com.yiwen.playground.persistence.repository;
import com.yiwen.playground.persistence.entity.BattleField;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BattleFieldRepository extends JpaRepository<BattleField, Long> {
    BattleField findById(long id);
    List<BattleField> findAll();
    BattleField saveAndFlush(BattleField battleField);
    List<BattleField> findByName(String name);
}
