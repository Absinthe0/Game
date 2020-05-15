package com.yiwen.playground.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity(name="battle")
@AllArgsConstructor
@NoArgsConstructor
public class Battle implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String battleStatus;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public Long getId() {
        return id;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    @JsonManagedReference
    public Set<Player> getPlayers() {
        return players;
    }

    public String getBattleStatus() {
        return battleStatus;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    @ManyToOne
    @JoinColumn(name = "battle_field_id", nullable = true)
    private BattleField battleField;


    @ManyToMany(cascade= { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "battle_participants",
            joinColumns = {@JoinColumn(name = "battle_id")},
            inverseJoinColumns = {@JoinColumn(name = " player_id")}
    )
    private Set<Player> players;

}
