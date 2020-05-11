package com.yiwen.playground.model;

import com.fasterxml.jackson.annotation.*;
import com.yiwen.playground.persistence.entity.BattleField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BattleDTO implements Serializable {

    @JsonProperty("battleId")
    private Long id;
    private String battleStatus;

    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime startAt;
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime endAt;

    private BattleFieldDTO battleField;

    private List<PlayerDTO> players;
}
