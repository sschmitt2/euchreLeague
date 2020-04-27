package com.euchreleague.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class to represent a role
 *
 * @author sschmitt
 */
@Entity(name = "UserRoles")
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * Instantiates a new UserRoles.
     */
    public UserRoles() {
    }


    /**
     * Instantiates a new User roles.
     *
     * @param roleName the role name
     * @param userName the user name
     * @param user     the user
     */
    public UserRoles(String roleName, String userName, User user) {
        this.roleName = roleName;
        this.userName = userName;
        this.user = user;
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
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoles userRoles = (UserRoles) o;
        return id == userRoles.id &&
                roleName.equals(userRoles.roleName) &&
                userName.equals(userRoles.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, userName);
    }
}
