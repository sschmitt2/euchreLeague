package com.euchreleague.persistence;

import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
// add unit tests to achieve 100% code coverage of your dao.
// You should run these tests repeatedly, in any order, and they should all pass every time!
// Javadoc comments
class UserDaoTest {

    GenericDao dao;

    /**
     * Sets up the User and User Role table with fresh data and creates database instance
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(User.class);
    }

    /**
     * verifies success of getting id
     */
    @Test
    void getById() {
        String firstName = "John";
        String lastName = "Doe";
        String userName = "jdoe";
        String password = "supersecret1";
        User retrievedUser = (User)dao.getById(1);
        assertEquals(firstName, retrievedUser.getFirstName());
        assertEquals(lastName, retrievedUser.getLastName());
        assertEquals(userName, retrievedUser.getUserName());
        assertEquals(password, retrievedUser.getUserPassword());
    }

    /**
     * verifies that you can save and update a new user
     */
    @Test
    void saveOrUpdate() {
        String newFirstName = "Sarah";
        String newLastName = "Schmitt";
        String newUserName = "sschmitt";
        User userToUpdate = (User)dao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        userToUpdate.setLastName(newLastName);
        userToUpdate.setUserName(newUserName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById(1);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * verifies that you insert a new user
     */
    @Test
    void insert() {
        String newFirstName = "Bob The";
        String newLastName = "Builder";
        String newUserName = "bbuilder";
        String newPassword = "secret";

        User newUser = new User(newFirstName, newLastName, newUserName, newPassword);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * verifies that you can delete a user
     */
    @Test
    void delete() {
        User retrievedUser = (User) dao.getById(1);
        assertNotNull(retrievedUser);
        dao.delete(retrievedUser);

    }

    /**
     * verifies that you can retrieve all users
     */
    @Test
    void getAll() {
        dao = new GenericDao(UserRoles.class);
        List<UserRoles> userRoles = dao.getAll();
        assertEquals(4, userRoles.size());
    }
}