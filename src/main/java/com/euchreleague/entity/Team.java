package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * A class to represent a team.
 *
 * @author sschmitt
 */
@Entity(name = "Team")
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "player1_id", referencedColumnName = "id")
    private User player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", referencedColumnName = "id")
    private User player2;

    @OneToMany(mappedBy = "team1", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Match> match1 = new HashSet<>();

    @OneToMany(mappedBy = "team2", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Match> match2 = new HashSet<>();

    /**
     * Instantiates a new Team.
     */
    public Team() {
    }

    public Team(User player1, User player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public Set<Match> getMatch1() {
        return match1;
    }

    public void setMatch1(Set<Match> match1) {
        this.match1 = match1;
    }

    public Set<Match> getMatch2() {
        return match2;
    }

    public void setMatch2(Set<Match> match2) {
        this.match2 = match2;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                player1.equals(team.player1) &&
                player2.equals(team.player2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player1, player2);
    }
}
