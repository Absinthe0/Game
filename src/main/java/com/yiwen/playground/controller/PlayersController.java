package com.yiwen.playground.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yiwen.playground.model.BattleDTO;
import com.yiwen.playground.model.CreateBattleMessage;
import com.yiwen.playground.model.PlayerDTO;
import com.yiwen.playground.persistence.entity.Player;
import com.yiwen.playground.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/players")
@RequiredArgsConstructor
@Api(value= "Player Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = { "Player API" })
public class PlayersController {

    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping(value="")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Invalid Player ID supplied", response = BattleDTO.class),
                    @ApiResponse(code = 404, message = "Player not found"),
                    @ApiResponse(code = 500, message = "Server Error")
            })
    public List<PlayerDTO> getPlayers(@RequestParam(required = false) String firstName, String lastName) {

        List<Player> players;
        if (firstName != null && lastName != null) {
            players = playerService.findByName(firstName, lastName);
        } else {
            players = playerService.findAll();
        }
        List<PlayerDTO> playerDTOs = new ArrayList<>();
        players.forEach(x -> playerDTOs.add(modelMapper.map(x,PlayerDTO.class)));
        return playerDTOs;
    }

    @GetMapping(value = "/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Invalid player ID supplied", response = BattleDTO.class),
                    @ApiResponse(code = 404, message = "Player not found"),
                    @ApiResponse(code = 500, message = "Server Error")
            })
    public PlayerDTO findById(@PathVariable("id") long id) {
        return modelMapper.map(playerService.findById(id),PlayerDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDTO create(@RequestBody PlayerDTO playerDTO) {
        Player player = modelMapper.map(playerDTO, Player.class);
        player = playerService.newPlayer(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    @PostMapping(value = "/{id}/requestBattle")
    public void requestBattle(
            @PathVariable("id") long id,
            @RequestBody CreateBattleMessage createBattleMessage) {
        this.template.send("topic1", createBattleMessage);
    }
}
