package com.yiwen.playground.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@Entity(name="battle")
@AllArgsConstructor
@NoArgsConstructor
public class Battle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String battleStatus;
    private Timestamp startAt;
    private Timestamp endAt;

    @ManyToOne
    @JoinColumn(name = "battle_field_id", nullable = true)
    private BattleField battleField;

    @ManyToMany(cascade= { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "battle_participants",
            joinColumns = {@JoinColumn(name = "battle_id")},
            inverseJoinColumns = {@JoinColumn(name = " player_id")}
    )
    private Set<Player> players;

}
