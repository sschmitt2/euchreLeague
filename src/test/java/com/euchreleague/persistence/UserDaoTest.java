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

    /**
     * The User dao.
     */
    UserDao userDao;

    /**
     * The User roles dao.
     */
    UserRolesDao userRolesDao;


    /**
     * Sets up the User and User Role table with fresh data and creates database instance
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new UserDao();
        userRolesDao = new UserRolesDao();
    }

    /**
     * verifies success of getting id
     */
    @Test
    void getById() {
        String firstName = "John";
        String lastName = "Doe";
        String userName = "jdoe";
        User retrievedUser = userDao.getById(1);
        assertEquals(firstName, retrievedUser.getFirstName());
        assertEquals(lastName, retrievedUser.getLastName());
        assertEquals(userName, retrievedUser.getUserName());
    }

    /**
     * verifies that you can save and update a new user
     */
    @Test
    void saveOrUpdate() {
        String newFirstName = "Sarah";
        String newLastName = "Schmitt";
        String newUserName = "sschmitt";
        User userToUpdate = userDao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        userToUpdate.setLastName(newLastName);
        userToUpdate.setUserName(newUserName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = userDao.getById(1);
        assertEquals(newFirstName, retrievedUser.getFirstName());
        assertEquals(newLastName, retrievedUser.getLastName());
        assertEquals(newUserName, retrievedUser.getUserName());
    }

    /**
     * verifies that you insert a new user
     */
    @Test
    void insert() {
        String newFirstName = "Bob The";
        String newLastName = "Builder";
        String newUserName = "bbuilder";
        User newUser = new User(newFirstName, newLastName, newUserName);
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = userDao.getById(id);
        assertEquals(newFirstName, insertedUser.getFirstName());
        assertEquals(newLastName, insertedUser.getLastName());
        assertEquals(newUserName, insertedUser.getUserName());
    }

    /**
     * verifies that you can delete a user
     */
    @Test
    void delete() {
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        userDao.delete(retrievedUser);

    }

    /**
     * verifies that you can retrieve all users
     */
    @Test
    void getAll() {
        List<UserRoles> userRoles = userRolesDao.getAll();
        assertEquals(1, userRoles.size());
    }
}