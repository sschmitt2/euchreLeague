
package com.euchreleague.controller;


import com.euchreleague.entity.League;
import com.euchreleague.entity.Match;
import com.euchreleague.entity.Team;
import com.euchreleague.entity.User;
import com.euchreleague.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(
        urlPatterns = {"/matches"}
)

public class DisplayMatchData extends HttpServlet {

    GenericDao<Match> matchDao = new GenericDao(Match.class);
    GenericDao<Team> teamDao = new GenericDao(Team.class);
    GenericDao<League> leagueDao = new GenericDao(League.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Match> matches = matchDao.getAll();

        req.setAttribute("matches", matches);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/matches.jsp");
        dispatcher.forward(req, resp);
    }
}