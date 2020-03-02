package com.euchreleague.persistence;

import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// add unit tests to achieve 100% code coverage of your dao.
// You should run these tests repeatedly, in any order, and they should all pass every time!
// Javadoc comments
class UserDaoTest {

    UserDao userDao;

    UserRolesDao userRolesDao;


    /**
     * Sets up the book table with fresh data and creates database instance
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
        User retrievedUser = userDao.getById(1);
        
        assertEquals("John", retrievedUser.getFirstName());
        assertEquals("Doe", retrievedUser.getLastName());
        assertEquals("jdoe", retrievedUser.getUserName());
    }

    /**
     * verifies that you can save and update a new book
     */
    @Test
    void saveOrUpdate() {
        String newFirstName = "Sarah";
        User userToUpdate = userDao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = userDao.getById(1);
        assertEquals(newFirstName, retrievedUser.getFirstName());
    }
    /**
     * verifies that you insert a new book
     */
    @Test
    void insert() {
        User newUser = new User("Sarah", "Schmitt", "sschmitt");
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = userDao.getById(id);
        assertEquals("Sarah", insertedUser.getFirstName());
        assertEquals("Schmitt", insertedUser.getLastName());
        assertEquals("sschmitt", insertedUser.getUserName());
    }

    /**
     * verifies that you can delete a book
     */
    @Test
    void delete() {
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        userDao.delete(retrievedUser);

    }

    /**
     * verifies that you can retrieve all books
     */
    @Test
    void getAll() {
        List<UserRoles> userRoles = userDao.getAll();
        assertEquals(2, userRoles.size());
    }
}