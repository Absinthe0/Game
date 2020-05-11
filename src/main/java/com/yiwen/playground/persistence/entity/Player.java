package com.yiwen.playground.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@Entity(name="player")
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

    @ManyToMany(mappedBy = "players", cascade= { CascadeType.ALL }, fetch = FetchType.LAZY)
 /*   @JoinTable(
            name = "battle_participants",
            joinColumns = {@JoinColumn(name = "player_id")},
            inverseJoinColumns = {@JoinColumn(name = "battle_id")}
    )

  */
    private Set<Battle> battles = new HashSet<>();
}
