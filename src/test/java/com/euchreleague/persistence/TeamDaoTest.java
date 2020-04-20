package com.euchreleague.persistence;

import com.euchreleague.entity.Team;
import com.euchreleague.entity.User;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamDaoTest {

    GenericDao dao;

    /**
     * Sets up the User and User Role table with fresh data and creates database instance
     */
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

}
