package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * A class to represent matches
 *
 * @author sschmitt
 */
@Entity(name = "Match")
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int id;

    @Column(name = "team1_id")
    private int teamOneId;

    @Column(name = "team2_id")
    private int teamTwoId;

    @Column(name = "score_1_1")
    private int teamOneScoreOne;

    @Column(name = "score_2_1")
    private int teamTwoScoreOne;

    @Column(name = "score_1_2")
    private int teamOneScoreTwo;

    @Column(name = "score_2_2")
    private int teamTwoScoreTwo;

    @Column(name = "score_1_3")
    private int teamOneScoreThree;

    @Column(name = "score_2_3")
    private int teamTwoScoreThree;

    @Column(name = "date_of_play")
    private Date dateOfPlay;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "id", referencedColumnName = "team1_id"),
            @JoinColumn(name = "id", referencedColumnName = "team2_id")
    })
    private Team team;

    /**
     * Instantiates a new Match.
     */
    public Match() {
    }

    /**
     * Instantiates a new Match.
     *
     * @param teamOneId         the team one id
     * @param teamTwoId         the team two id
     * @param teamOneScoreOne   the team one score one
     * @param teamTwoScoreOne   the team two score one
     * @param teamOneScoreTwo   the team one score two
     * @param teamTwoScoreTwo   the team two score two
     * @param teamOneScoreThree the team one score three
     * @param teamTwoScoreThree the team two score three
     * @param dateOfPlay        the date of play
     * @param team              the team
     */
    public Match(int teamOneId, int teamTwoId, int teamOneScoreOne, int teamTwoScoreOne, int teamOneScoreTwo, int teamTwoScoreTwo, int teamOneScoreThree, int teamTwoScoreThree, Date dateOfPlay, Team team) {
        this.teamOneId = teamOneId;
        this.teamTwoId = teamTwoId;
        this.teamOneScoreOne = teamOneScoreOne;
        this.teamTwoScoreOne = teamTwoScoreOne;
        this.teamOneScoreTwo = teamOneScoreTwo;
        this.teamTwoScoreTwo = teamTwoScoreTwo;
        this.teamOneScoreThree = teamOneScoreThree;
        this.teamTwoScoreThree = teamTwoScoreThree;
        this.dateOfPlay = dateOfPlay;
        this.team = team;
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
     * Gets team one id.
     *
     * @return the team one id
     */
    public int getTeamOneId() {
        return teamOneId;
    }

    /**
     * Sets team one id.
     *
     * @param teamOneId the team one id
     */
    public void setTeamOneId(int teamOneId) {
        this.teamOneId = teamOneId;
    }

    /**
     * Gets team two id.
     *
     * @return the team two id
     */
    public int getTeamTwoId() {
        return teamTwoId;
    }

    /**
     * Sets team two id.
     *
     * @param teamTwoId the team two id
     */
    public void setTeamTwoId(int teamTwoId) {
        this.teamTwoId = teamTwoId;
    }

    /**
     * Gets team one score one.
     *
     * @return the team one score one
     */
    public int getTeamOneScoreOne() {
        return teamOneScoreOne;
    }

    /**
     * Sets team one score one.
     *
     * @param teamOneScoreOne the team one score one
     */
    public void setTeamOneScoreOne(int teamOneScoreOne) {
        this.teamOneScoreOne = teamOneScoreOne;
    }

    /**
     * Gets team two score one.
     *
     * @return the team two score one
     */
    public int getTeamTwoScoreOne() {
        return teamTwoScoreOne;
    }

    /**
     * Sets team two score one.
     *
     * @param teamTwoScoreOne the team two score one
     */
    public void setTeamTwoScoreOne(int teamTwoScoreOne) {
        this.teamTwoScoreOne = teamTwoScoreOne;
    }

    /**
     * Gets team one score two.
     *
     * @return the team one score two
     */
    public int getTeamOneScoreTwo() {
        return teamOneScoreTwo;
    }

    /**
     * Sets team one score two.
     *
     * @param teamOneScoreTwo the team one score two
     */
    public void setTeamOneScoreTwo(int teamOneScoreTwo) {
        this.teamOneScoreTwo = teamOneScoreTwo;
    }

    /**
     * Gets team two score two.
     *
     * @return the team two score two
     */
    public int getTeamTwoScoreTwo() {
        return teamTwoScoreTwo;
    }

    /**
     * Sets team two score two.
     *
     * @param teamTwoScoreTwo the team two score two
     */
    public void setTeamTwoScoreTwo(int teamTwoScoreTwo) {
        this.teamTwoScoreTwo = teamTwoScoreTwo;
    }

    /**
     * Gets team one score three.
     *
     * @return the team one score three
     */
    public int getTeamOneScoreThree() {
        return teamOneScoreThree;
    }

    /**
     * Sets team one score three.
     *
     * @param teamOneScoreThree the team one score three
     */
    public void setTeamOneScoreThree(int teamOneScoreThree) {
        this.teamOneScoreThree = teamOneScoreThree;
    }

    /**
     * Gets team two score three.
     *
     * @return the team two score three
     */
    public int getTeamTwoScoreThree() {
        return teamTwoScoreThree;
    }

    /**
     * Sets team two score three.
     *
     * @param teamTwoScoreThree the team two score three
     */
    public void setTeamTwoScoreThree(int teamTwoScoreThree) {
        this.teamTwoScoreThree = teamTwoScoreThree;
    }

    /**
     * Gets date of play.
     *
     * @return the date of play
     */
    public Date getDateOfPlay() {
        return dateOfPlay;
    }

    /**
     * Sets date of play.
     *
     * @param dateOfPlay the date of play
     */
    public void setDateOfPlay(Date dateOfPlay) {
        this.dateOfPlay = dateOfPlay;
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", teamOneId=" + teamOneId +
                ", teamTwoId=" + teamTwoId +
                ", teamOneScoreOne=" + teamOneScoreOne +
                ", teamTwoScoreOne=" + teamTwoScoreOne +
                ", teamOneScoreTwo=" + teamOneScoreTwo +
                ", teamTwoScoreTwo=" + teamTwoScoreTwo +
                ", teamOneScoreThree=" + teamOneScoreThree +
                ", teamTwoScoreThree=" + teamTwoScoreThree +
                ", dateOfPlay=" + dateOfPlay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return id == match.id &&
                teamOneId == match.teamOneId &&
                teamTwoId == match.teamTwoId &&
                teamOneScoreOne == match.teamOneScoreOne &&
                teamTwoScoreOne == match.teamTwoScoreOne &&
                teamOneScoreTwo == match.teamOneScoreTwo &&
                teamTwoScoreTwo == match.teamTwoScoreTwo &&
                teamOneScoreThree == match.teamOneScoreThree &&
                teamTwoScoreThree == match.teamTwoScoreThree &&
                dateOfPlay.equals(match.dateOfPlay) &&
                team.equals(match.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamOneId, teamTwoId, teamOneScoreOne, teamTwoScoreOne, teamOneScoreTwo, teamTwoScoreTwo, teamOneScoreThree, teamTwoScoreThree, dateOfPlay, team);
    }
}
