package com.euchreleague.persistence;

import com.euchreleague.entity.Match;
import com.euchreleague.entity.Team;
import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchDaoTest {

    GenericDao dao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao<>(Match.class);
    }

    @Test
    void getByIdSuccess() {
//
//        Match retrievedMatch = (Match) dao.getById(1);
//        assertNotNull(retrievedMatch);
//        assertEquals(1, retrievedMatch.getId());
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
//
//        String roleName = "player";
//        UserRoles role = new UserRoles(roleName, newUserName, newUser);
//        newUser.addRole(role);
//        int id = dao.insert(role);
//        assertNotEquals(0, id);
//
//        String roleName2 = "player";
//        UserRoles role2 = new UserRoles(roleName2, newUserName2, newUser2);
//        int roleId = dao.insert(role2);
//        assertNotEquals(0, roleId);
//
//        Team newTeam = new Team(newUser, newUser2);
//        int teamId = dao.insert(newTeam);
//        assertNotEquals(0, teamId);
//
//        UserRoles insertedRole = (UserRoles) dao.getById(id);
//        UserRoles insertedRole2 = (UserRoles) dao.getById(roleId);
//        Team insertedTeam = (Team) dao.getById(teamId);
//        assertEquals(role, insertedRole);
//        assertEquals(role2, insertedRole2);
//        assertEquals(newTeam, insertedTeam);

    }
}
