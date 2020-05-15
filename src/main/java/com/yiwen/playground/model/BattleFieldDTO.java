package com.yiwen.playground.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BattleFieldDTO implements Serializable {

    @JsonProperty("battle_field_id")
    private Long id;
    @JsonProperty("battle_field_name")
    private String name;
    @JsonProperty("battle_field_description")
    private String description;

}
