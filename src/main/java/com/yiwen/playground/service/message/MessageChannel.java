package com.yiwen.playground.service.message;

import com.yiwen.playground.model.messages.CreateBattleMessage;
import com.yiwen.playground.model.messages.JoinBattleMessage;
import com.yiwen.playground.persistence.entity.Battle;
import com.yiwen.playground.persistence.entity.BattleField;
import com.yiwen.playground.persistence.entity.Player;
import com.yiwen.playground.service.BattleFieldService;
import com.yiwen.playground.service.BattleService;
import com.yiwen.playground.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class MessageChannel {

    @Autowired
    private BattleService battleService;
    @Autowired
    private BattleFieldService battleFieldService;
    @Autowired
    private PlayerService playerService;

    @KafkaListener(groupId = "1", topics = "topic1")
    @Transactional
    public void initiateBattle(CreateBattleMessage msg) throws Exception {
        System.out.println("Message:" + msg);
        Set<Player> players = new HashSet<>();
        BattleField battleFiled = battleFieldService.findBattleFieldById(msg.getBattleFieldId());

        for (Long playerId : msg.getPlayers()) {
            players.add(playerService.findById(playerId));
        }

        Battle battle = Battle.builder()
                .battleField(battleFiled)
                .battleStatus("Created")
                .players(players)
                .startAt(LocalDateTime.now())
                .endAt(LocalDateTime.now().plusHours(1))
                .build();

        battleService.saveOrUpdate(battle);
    }

    @KafkaListener(groupId = "1", topics = "topic2")
    @Transactional
    public void joinBattle(JoinBattleMessage msg) throws Exception {
        Battle battle = battleService.findById(msg.getBattleId());
        Player player = playerService.findById(msg.getPlayerId());

        battle.getPlayers().add(player);
        battleService.saveOrUpdate(battle);
    }
}
