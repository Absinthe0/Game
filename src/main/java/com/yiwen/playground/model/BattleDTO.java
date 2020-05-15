package com.yiwen.playground.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BattleDTO implements Serializable {
    private Long id;
    private String battleStatus;

    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime startAt;
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime endAt;

    private BattleFieldDTO battleField;

    private List<PlayerDTO> players;
}
