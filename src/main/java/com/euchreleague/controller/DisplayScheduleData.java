package com.euchreleague.controller;

import com.euchreleague.entity.League;
import com.euchreleague.entity.Team;
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
        urlPatterns = {"/schedules"}
)

public class DisplayScheduleData extends HttpServlet {

    GenericDao<Team> teamDao = new GenericDao(Team.class);
    GenericDao<League> leagueDao = new GenericDao(League.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Team> pretendTeams = teamDao.getAll();

        List<League> leagues = leagueDao.getAll();


        req.setAttribute("team1", pretendTeams.get(0));
        req.setAttribute("team2", pretendTeams.get(1));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/schedules.jsp");
        dispatcher.forward(req, resp);
    }
}