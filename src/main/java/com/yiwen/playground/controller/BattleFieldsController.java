package com.yiwen.playground.controller;

import com.yiwen.playground.model.BattleFieldDTO;
import com.yiwen.playground.persistence.entity.BattleField;
import com.yiwen.playground.service.BattleFieldService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/battlefields")
@RequiredArgsConstructor
@Api(value= "Battle Field Controller", produces = MediaType.APPLICATION_JSON_VALUE,tags = { "Battle Field API" })
public class BattleFieldsController {

    private final BattleFieldService battleFieldService;
    private final ModelMapper modelMapper;

    @GetMapping(value="")
    public List<BattleFieldDTO> findAll(@RequestParam(required = false) String name) {
        List<BattleField> battleFields;
        if (name != null) {
            battleFields = battleFieldService.findBattleFieldByName(name);
        } else {
            battleFields = battleFieldService.findAll();
        }
        List<BattleFieldDTO> battleFieldDTOs = new ArrayList<>();
        battleFields.forEach(x -> battleFieldDTOs.add(modelMapper.map(x,BattleFieldDTO.class)));
        return battleFieldDTOs;
    }

    @GetMapping(value = "/{id}")
    public BattleFieldDTO findById(@PathVariable("id") long id) {
        return modelMapper.map(battleFieldService.findBattleFieldById(id),BattleFieldDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BattleFieldDTO create(@RequestBody BattleFieldDTO battleFieldDTO)
    {
        BattleField battleField = modelMapper.map(battleFieldDTO, BattleField.class);
        battleField = battleFieldService.saveOrUpdate(battleField);

        return modelMapper.map(battleField, BattleFieldDTO.class);
    }

}
