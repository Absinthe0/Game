package com.yiwen.playground.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@Entity(name = "battle_field")
@AllArgsConstructor
@NoArgsConstructor
public class BattleField {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "battleField")
    private Set<Battle> battles;
}
