package com.euchreleague.persistence;


import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for BookDao
 *
 * @author Paula Waite
 */
// Update the tests to account for the new author class
class UserRolesDaoTest {


    /**
     * The Book dao.
     */
    UserRolesDao userRolesDao;


    /**
     * The Author dao.
     */
    UserDao userDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new UserDao();
        userRolesDao = new UserRolesDao();
    }

    /**
     * Verify successful retrieval of a Book
     */
    @Test
    void getByIdSuccess() {
        UserRoles retrievedUser = userRolesDao.getById(1);
        assertEquals("admin", retrievedUser.getRoleName());
    }

    /**
     * Verify successful insert of a Book and Author
     */
    @Test
    void insertSuccess() {
        String firstName = "Jen";
        String lastName = "Sincero";
        String userName = "jsincero";
        User newUser = new User(firstName, lastName, userName);
        int userId = userDao.insert(newUser);
        String roleName = "player";
        UserRoles newUserRole = new UserRoles(roleName, newUser);
        int id = userRolesDao.insert(newUserRole);
        assertNotEquals(0,id);
        UserRoles insertedUserRole = userRolesDao.getById(id);
        User insertedUser = userDao.getById(userId);
        assertEquals(newUserRole, insertedUserRole);
    }

    /**
     * Verify successful retrieval of all Books
     */
    @Test
    void getAllSuccess() {
        List<UserRoles> users = userRolesDao.getAll();
        assertEquals(1, users.size());
    }

    /**
     * Verify successful update of a Book
     */
    @Test
    void updateSuccess() {
        String newRole = "player";
        UserRoles roleToUpdate = userRolesDao.getById(1);
        roleToUpdate.setRoleName(newRole);
        userRolesDao.saveOrUpdate(roleToUpdate);
        UserRoles roleAfterUpdate = userRolesDao.getById(1);
        assertEquals(roleToUpdate, roleAfterUpdate);
    }

    /**
     * Verify successful delete of Book
     */
    @Test
    void deleteSuccess() {
        UserRoles retrievedRoleToDelete = userRolesDao.getById(1);
        assertNotNull(retrievedRoleToDelete);
        userRolesDao.delete(retrievedRoleToDelete);
    }


}


