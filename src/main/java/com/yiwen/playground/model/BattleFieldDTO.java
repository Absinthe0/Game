package com.yiwen.playground.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BattleFieldDTO implements Serializable {

    @JsonProperty("battleFieldId")
    private Long id;
    @JsonProperty("battleFieldName")
    private String name;
    @JsonProperty("battleFieldDescription")
    private String description;

    @JsonIgnore
    private BattleDTO battle;
}
