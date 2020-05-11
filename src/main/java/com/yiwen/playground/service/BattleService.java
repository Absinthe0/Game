package com.yiwen.playground.service;

import com.yiwen.playground.model.CreateBattleMessage;
import com.yiwen.playground.persistence.entity.Battle;


import java.util.*;

public interface BattleService {

    Battle saveOrUpdate(Battle battle);
    Battle findById(long id);
    List<Battle> findAll();
}
