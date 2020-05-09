
package com.euchreleague.controller;


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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Match> pretendMatches = matchDao.getAll();

        List<Team> teams = teamDao.getAll();

        req.setAttribute("match1", pretendMatches.get(0));
        req.setAttribute("match2", pretendMatches.get(1));
        req.setAttribute("team1", teams.get(0));
        req.setAttribute("team2", teams.get(1));
        req.setAttribute("team3", teams.get(2));
        req.setAttribute("team4", teams.get(3));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/matches.jsp");
        dispatcher.forward(req, resp);
    }
}