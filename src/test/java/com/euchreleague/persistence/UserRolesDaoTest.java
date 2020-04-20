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

    GenericDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(UserRoles.class);
    }

    /**
     * Verify successful retrieval of a Book
     */
    @Test
    void getByIdSuccess() {
        String roleName = "admin";
        UserRoles retrievedUser = (UserRoles) dao.getById(1);
        assertEquals(roleName, retrievedUser.getRoleName());
    }

    /**
     * Verify successful insert of a Book and Author
     */
    @Test
    void insertSuccess() {

        String newUserName = "rgourlie";
        User newUser = new User("Roger", "Gourlie", newUserName, "secret");
        int userId = dao.insert(newUser);
        assertNotEquals(0, userId);

        String roleName = "admin";
        UserRoles role = new UserRoles(roleName, newUser);
        newUser.addRole(role);

        int id = dao.insert(role);

        assertNotEquals(0, id);

        UserRoles insertedRole = (UserRoles) dao.getById(id);
        assertEquals(roleName, insertedRole.getRoleName());
        assertNotNull(insertedRole.getUser());
        assertEquals(role, insertedRole);

    }

    /**
     * Verify successful retrieval of all Books
     */
    @Test
    void getAllSuccess() {
        List<UserRoles> users = dao.getAll();
        assertEquals(2, users.size());
    }

    /**
     * Verify successful update of a Book
     */
    @Test
    void updateSuccess() {
        String newRole = "player";
        UserRoles roleToUpdate = (UserRoles) dao.getById(1);
        roleToUpdate.setRoleName(newRole);
        dao.saveOrUpdate(roleToUpdate);
        UserRoles roleAfterUpdate = (UserRoles) dao.getById(1);
        assertEquals(roleToUpdate, roleAfterUpdate);
    }

    /**
     * Verify successful delete of Book
     */
    @Test
    void deleteSuccess() {
        UserRoles retrievedRoleToDelete = (UserRoles) dao.getById(1);
        assertNotNull(retrievedRoleToDelete);
        dao.delete(retrievedRoleToDelete);
    }


}


