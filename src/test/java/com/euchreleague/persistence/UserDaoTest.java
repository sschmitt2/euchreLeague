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

    GenericDao<User> dao;
    GenericDao<UserRoles> roleDao;

    /**
     * Sets up the User and User Role table with fresh data and creates database instance
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao<>(User.class);
        roleDao = new GenericDao<>(UserRoles.class);
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
        String email = "sschmitt07+jdoe@gmail.com";
        User retrievedUser = dao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals(firstName, retrievedUser.getFirstName());
        assertEquals(lastName, retrievedUser.getLastName());
        assertEquals(userName, retrievedUser.getUserName());
        assertEquals(password, retrievedUser.getUserPassword());
        assertEquals(email, retrievedUser.getEmail());
    }

    /**
     * verifies that you can save and update a new user
     */
    @Test
    void saveOrUpdate() {
        String newFirstName = "Sarah";
        String newLastName = "Schmitt";
        String newUserName = "sschmitt";
        User userToUpdate = dao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        userToUpdate.setLastName(newLastName);
        userToUpdate.setUserName(newUserName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(1);
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
        String newEmail = "bbuilder@gmail.com";

        User newUser = new User(newFirstName, newLastName, newUserName, newPassword, newEmail);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * verifies that you can delete a user
     */
    @Test
    void delete() {
        User retrievedUser = dao.getById(1);
        assertNotNull(retrievedUser);
        dao.delete(retrievedUser);

    }

    /**
     * verifies that you can retrieve all users
     */
    @Test
    void getAll() {
        List<UserRoles> userRoles = roleDao.getAll();
        int expectedUserRoles = userRoles.size();
        assertEquals(expectedUserRoles, userRoles.size());
    }
}