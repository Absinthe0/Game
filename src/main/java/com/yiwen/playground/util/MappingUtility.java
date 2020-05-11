package com.yiwen.playground.util;

import com.yiwen.playground.model.BattleFieldDTO;
import com.yiwen.playground.persistence.entity.BattleField;
import lombok.RequiredArgsConstructor;
import org.modelmapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class MappingUtility {

    @Autowired
    private final ModelMapper modelMapper;

    public BattleField convertToEntity(BattleFieldDTO battleFieldDTO) {
        return modelMapper.map(battleFieldDTO, BattleField.class);
    }
    public List<BattleField> convertToEntity(List<BattleFieldDTO> battleFieldDTOs) {
        List<BattleField> battleFields = new ArrayList<>();
        battleFieldDTOs.forEach((BattleFieldDTO battleFieldDTO) -> battleFields.add(modelMapper.map(battleFieldDTO, BattleField.class)));
        return battleFields;
    }

    public BattleFieldDTO convertToDTO(BattleField battleField) {
        return modelMapper.map(battleField, BattleFieldDTO.class);
    }
    public List<BattleFieldDTO> convertToDTO(List<BattleField> battleFields) {
        List<BattleFieldDTO> battleFieldDTOs = new ArrayList<>();
        battleFields.forEach(battleField -> battleFieldDTOs.add(modelMapper.map(battleField, BattleFieldDTO.class)));
        return battleFieldDTOs;
    }

}
