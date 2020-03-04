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

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_name",
            foreignKey = @ForeignKey(name = "USER_NAME_FK")
    )
    private User user;

    public Team(int playerOneId, int playerTwoId, String userName, String name) {
        this.playerOneId = playerOneId;
        this.playerTwoId = playerTwoId;
        this.name = name;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerOneId() {
        return playerOneId;
    }

    public void setPlayerOneId(int playerOneId) {
        this.playerOneId = playerOneId;
    }

    public int getPlayerTwoId() {
        return playerTwoId;
    }

    public void setPlayerTwoId(int playerTwoId) {
        this.playerTwoId = playerTwoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", playerOneId=" + playerOneId +
                ", playerTwoId=" + playerTwoId +
                ", name='" + name + '\'' +
                '}';
    }
}
