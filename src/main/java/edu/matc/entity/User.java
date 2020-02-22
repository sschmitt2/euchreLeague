package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
/**
 * A class to represent a user.
 *
 * @author sschmitt
 */

public class User {
    private int id;
    private String userName;
    private String userPassword;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id           the id
     * @param userName     the user name
     * @param userPassword the user password
     */
    public User(int id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
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
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
