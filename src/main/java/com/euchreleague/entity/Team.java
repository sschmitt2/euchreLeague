package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "id",
            foreignKey = @ForeignKey(name = "teams_player1_id_fk")
    )
    private User user;

    /**
     * Instantiates a new Team.
     */
    public Team() {
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
}
