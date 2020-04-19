package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class to represent a team.
 *
 * @author sschmitt
 */
@Entity(name = "Team")
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int id;

    @Column(name = "player1_id")
    private int playerOneId;

    @Column(name = "player2_id")
    private int playerTwoId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id", referencedColumnName = "player1_id"),
            @JoinColumn(name = "id", referencedColumnName = "player2_id")
    })
    private User user;

    /**
     * Instantiates a new Team.
     */
    public Team() {
    }

    /**
     * Instantiates a new Team.
     *
     * @param playerOneId the player one id
     * @param playerTwoId the player two id
     * @param user        the user
     */
    public Team(int playerOneId, int playerTwoId, User user) {
        this.playerOneId = playerOneId;
        this.playerTwoId = playerTwoId;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets player one id.
     *
     * @return the player one id
     */
    public int getPlayerOneId() {
        return playerOneId;
    }

    /**
     * Sets player one id.
     *
     * @param playerOneId the player one id
     */
    public void setPlayerOneId(int playerOneId) {
        this.playerOneId = playerOneId;
    }

    /**
     * Gets player two id.
     *
     * @return the player two id
     */
    public int getPlayerTwoId() {
        return playerTwoId;
    }

    /**
     * Sets player two id.
     *
     * @param playerTwoId the player two id
     */
    public void setPlayerTwoId(int playerTwoId) {
        this.playerTwoId = playerTwoId;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", playerOneId=" + playerOneId +
                ", playerTwoId=" + playerTwoId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                playerOneId == team.playerOneId &&
                playerTwoId == team.playerTwoId &&
                user.equals(team.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerOneId, playerTwoId, user);
    }
}
