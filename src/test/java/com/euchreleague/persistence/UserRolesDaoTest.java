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

    UserDao userDao;



    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        userDao = new UserDao();
        userRolesDao = new UserRolesDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verify successful retrieval of a Book
     */
    @Test
    void getByIdSuccess() {
        String roleName = "admin";
        UserRoles retrievedUser = userRolesDao.getById(1);
        assertEquals(roleName, retrievedUser.getRoleName());
    }

    /**
     * Verify successful insert of a Book and Author
     */
    @Test
    void insertSuccess() {

        String newUserName = "rgourlie";
        User newUser = new User("Roger", "Gourlie", newUserName);
        int userId = userDao.insert(newUser);
        assertNotEquals(0, userId);

        String roleName = "admin";
        UserRoles role = new UserRoles(roleName, newUserName, newUser);
        newUser.addRole(role);

        int id = userRolesDao.insert(role);

        assertNotEquals(0, id);

        UserRoles insertedRole = userRolesDao.getById(id);
        assertEquals(roleName, insertedRole.getRoleName());
        assertNotNull(insertedRole.getUser());
        assertEquals(role, insertedRole);

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


