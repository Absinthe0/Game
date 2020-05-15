package com.yiwen.playground.controller;

import com.yiwen.playground.model.BattleDTO;
import com.yiwen.playground.model.BattleFieldDTO;
import com.yiwen.playground.persistence.entity.Battle;
import com.yiwen.playground.service.BattleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/battles")
@Api(value= "Battle Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = { "Battle API" })
public class BattlesController {

    protected Logger logger = Logger.getLogger(BattlesController.class.getName());

    private BattleService battleService;
    private final ModelMapper modelMapper;

    @Autowired
    public BattlesController(BattleService battleService, ModelMapper modelMapper) {
        this.battleService = battleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{battle_id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(
            value = {
                @ApiResponse(code = 400, message = "Invalid Battle ID supplied"),
                @ApiResponse(code = 404, message = "Battle not found"),
                @ApiResponse(code = 500, message = "Server Error")
    })
    public BattleDTO findById(@PathVariable("battle_id") long id) {
        logger.info(String.format("battle-service findById"));
        return modelMapper.map(battleService.findById(id),BattleDTO.class);
    }

    @GetMapping(value="")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "battle", response = BattleDTO.class),
                    @ApiResponse(code = 400, message = "bad request"),
                    @ApiResponse(code = 500, message = "Server Error")
            }
    )
    public List<Battle> getBattles() {
       //return battleService.findAll();
        return modelMapper.map(battleService.findAll(),new TypeToken<List<BattleDTO>>(){}.getType());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public BattleDTO add(@RequestBody BattleDTO battleDTO) {
        Battle battle = modelMapper.map(battleDTO, Battle.class);
        battle = battleService.saveOrUpdate(battle);
        return modelMapper.map(battle, BattleDTO.class);
    }
}
