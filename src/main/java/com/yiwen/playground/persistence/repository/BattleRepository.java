package com.yiwen.playground.persistence.repository;
import com.yiwen.playground.persistence.entity.Battle;

import com.yiwen.playground.persistence.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Long> {
    List<Battle> findAll();
    Battle findById(long id);
    Battle saveAndFlush(Battle battle);
}
