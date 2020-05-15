package com.yiwen.playground.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Entity(name="player")
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @JsonBackReference
    public Set<Battle> getBattles() {
        return battles;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setBattles(Set<Battle> battles) {
        this.battles = battles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /*@ManyToMany(cascade= { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "battle_participants",
            joinColumns = {@JoinColumn(name = " player_id")},
            inverseJoinColumns = {@JoinColumn(name = "battle_id")}
    )

     */

    @ManyToMany(mappedBy = "players", cascade= { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Set<Battle> battles;
}
