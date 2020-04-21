package com.euchreleague.persistence;

import com.euchreleague.entity.Team;
import com.euchreleague.entity.User;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TeamDaoTest {

    GenericDao dao;


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Team.class);
    }

    /**
     * verifies success of getting id
     */
    @Test
    void getById() {
        Team retrievedTeam = (Team) dao.getById(1);
        assertEquals(1, retrievedTeam.getId());
    }

    /**
     * verifies that you can save and update a new user
     */
    @Test
    void saveOrUpdate() {

    }

    @Test
    void insert() {
//        String newFirstName1 = "Bob";
//        String newLastName1 = "Builder";
//        String newUserName1 = "bbuilder";
//        String newPassword1 = "secret";
//
//        User newUser = new User(newFirstName1, newLastName1, newUserName1, newPassword1);
//        int id = dao.insert(newUser);
//        assertNotEquals(0,id);
//        User insertedUser = (User) dao.getById(id);
//        assertEquals(newUser, insertedUser);
    }

}
