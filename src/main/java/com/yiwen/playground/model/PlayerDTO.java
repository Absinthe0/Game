package com.yiwen.playground.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.yiwen.playground.persistence.entity.Battle;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PlayerDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
