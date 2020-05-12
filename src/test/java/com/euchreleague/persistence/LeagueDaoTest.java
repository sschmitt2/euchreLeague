package com.euchreleague.persistence;

import com.euchreleague.entity.League;
import com.euchreleague.entity.Team;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueDaoTest {

    GenericDao dao;


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao<>(League.class);
    }

    /**
     * verifies success of getting id
     */
    @Test
    void getById() {
//        Team retrievedTeam = (Team) dao.getById(1);
//        assertEquals(1, retrievedTeam.getId());
    }

    /**
     * verifies that you can save and update a new user
     */
    @Test
    void saveOrUpdate() {

    }

    /**
     * Verify successful insert of a Book and Author
     */
    @Test
    void insertSuccess() {
//        String newUserName = "hpotter";
//        User newUser = new User("Harry", "Potter", newUserName, "secret", "hpotter@gmail.com");
//        int userId = dao.insert(newUser);
//        assertNotEquals(0, userId);
//
//        String newUserName2 = "dmatthews";
//        User newUser2 = new User("Dave", "Matthews", newUserName2, "secret", "dmatthews@gmail.com");
//        int userId2 = dao.insert(newUser2);
//        assertNotEquals(0, userId2);
//
//        Team newTeam = new Team(newUser, newUser2);
//        int teamId = dao.insert(newTeam);
//        assertNotEquals(0, teamId);
//
//        User insertedUser = (User) dao.getById(userId);
//        User insertedUser2 = (User) dao.getById(userId2);
//        Team insertedTeam = (Team) dao.getById(teamId);
//        assertEquals(newUser, insertedUser);
//        assertEquals(newUser2, insertedUser2);
//        assertEquals(newTeam, insertedTeam);
    }

}
