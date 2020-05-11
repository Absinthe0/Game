package com.yiwen.playground.model;

import com.fasterxml.jackson.annotation.*;
import com.yiwen.playground.persistence.entity.Battle;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlayerDTO implements Serializable {

    @JsonProperty("playerId")
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime modifiedDate;


    @JsonIgnore
    private List<BattleDTO> battles;

}
