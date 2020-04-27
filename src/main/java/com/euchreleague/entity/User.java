package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

//TODO - finish project plan for the rest of the semester

/**
 * A class to represent a user.
 *
 * @author sschmitt
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    /**
     * The User.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<UserRoles> userRoles = new ArrayList<>();

    @OneToMany(mappedBy = "player1", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Team> team1 = new HashSet<>();

    @OneToMany(mappedBy = "player2", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Team> team2 = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param userName     the user name
     * @param userPassword the user password
     */
    public User(String firstName, String lastName, String userName, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Gets user roles.
     *
     * @return the user roles
     */
    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets user roles.
     *
     * @param userRoles the user roles
     */
    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets team 1.
     *
     * @return the team 1
     */
    public Set<Team> getTeam1() {
        return team1;
    }

    /**
     * Sets team 1.
     *
     * @param team1 the team 1
     */
    public void setTeam1(Set<Team> team1) {
        this.team1 = team1;
    }

    /**
     * Gets team 2.
     *
     * @return the team 2
     */
    public Set<Team> getTeam2() {
        return team2;
    }

    /**
     * Sets team 2.
     *
     * @param team2 the team 2
     */
    public void setTeam2(Set<Team> team2) {
        this.team2 = team2;
    }

    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(UserRoles role) {
        userRoles.add(role);
        role.setUser(this);
    }

    /**
     * Remove role.
     *
     * @param role the role
     */
    public void removeRole(UserRoles role) {
        userRoles.remove(role);
        role.setUser(null);
    }

    /**
     * Add team.
     *
     * @param team the team
     */
    public void addTeam(Team team) {
        team1.add(team);
        team.setPlayer1(this);
        team.setPlayer2(this);

    }

    /**
     * Remove team.
     *
     * @param team the team
     */
    public void removeTeam(Team team) {
        team1.remove(team);
        team.setPlayer1(null);
        team.setPlayer2(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName);
    }
}
