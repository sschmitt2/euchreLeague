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


    @ManyToOne
    @JoinColumn(name = "team1_id", referencedColumnName = "id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_id", referencedColumnName = "id")
    private Team team2;

    /**
     * Instantiates a new Match.
     */
    public Match() {
    }

    public Match(int teamOneScoreOne, int teamTwoScoreOne, int teamOneScoreTwo, int teamTwoScoreTwo, int teamOneScoreThree, int teamTwoScoreThree, Date dateOfPlay, Team team1, Team team2) {
        this.teamOneScoreOne = teamOneScoreOne;
        this.teamTwoScoreOne = teamTwoScoreOne;
        this.teamOneScoreTwo = teamOneScoreTwo;
        this.teamTwoScoreTwo = teamTwoScoreTwo;
        this.teamOneScoreThree = teamOneScoreThree;
        this.teamTwoScoreThree = teamTwoScoreThree;
        this.dateOfPlay = dateOfPlay;
        this.team1 = team1;
        this.team2 = team2;
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
    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
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
                teamOneScoreOne == match.teamOneScoreOne &&
                teamTwoScoreOne == match.teamTwoScoreOne &&
                teamOneScoreTwo == match.teamOneScoreTwo &&
                teamTwoScoreTwo == match.teamTwoScoreTwo &&
                teamOneScoreThree == match.teamOneScoreThree &&
                teamTwoScoreThree == match.teamTwoScoreThree &&
                dateOfPlay.equals(match.dateOfPlay) &&
                team1.equals(match.team1) &&
                team2.equals(match.team2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamOneScoreOne, teamTwoScoreOne, teamOneScoreTwo, teamTwoScoreTwo, teamOneScoreThree, teamTwoScoreThree, dateOfPlay, team1, team2);
    }
}
