package com.yiwen.playground.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yiwen.playground.model.CreateBattleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("topic1", what);
    }

    @PostMapping(value = "/requestBattle")
    public void requestBattle(
            @RequestBody CreateBattleMessage createBattleMessage) {

        this.template.send("topic1", createBattleMessage);
    }

    @PostMapping(value = "/requestBattle3")
    public void requestBattle3(
            @RequestBody CreateBattleMessage createBattleMessage) throws JsonProcessingException {
        String serialized =  new ObjectMapper().writeValueAsString(createBattleMessage);
        this.template.send("topic1", serialized);
    }
}