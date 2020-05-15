package com.yiwen.playground.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@Data
@Entity(name = "battle_field")
@AllArgsConstructor
@NoArgsConstructor
public class BattleField implements Serializable  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "battleField", cascade= { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Battle> battles;
}
