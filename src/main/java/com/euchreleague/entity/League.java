package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The type League.
 */
@Entity(name = "League")
@Table(name = "league")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User league;

    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    /**
     * Instantiates a new League.
     */
    public League() {
    }

    /**
     * Instantiates a new League.
     *
     * @param league    the league
     * @param name      the name
     * @param startDate the start date
     * @param endDate   the end date
     */
    public League(User league, String name, Date startDate, Date endDate) {
        this.league = league;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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
     * Gets league.
     *
     * @return the league
     */
    public User getLeague() {
        return league;
    }

    /**
     * Sets league.
     *
     * @param league the league
     */
    public void setLeague(User league) {
        this.league = league;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", league=" + league +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league1 = (League) o;
        return id == league1.id &&
                league.equals(league1.league) &&
                name.equals(league1.name) &&
                startDate.equals(league1.startDate) &&
                endDate.equals(league1.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, league, name, startDate, endDate);
    }
}
