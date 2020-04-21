package com.euchreleague.persistence;

import com.euchreleague.entity.Match;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchDaoTest {

    GenericDao dao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Match.class);
    }

    @Test
    void getByIdSuccess() {

        Match retrievedMatch = (Match) dao.getById(1);
    }


}
