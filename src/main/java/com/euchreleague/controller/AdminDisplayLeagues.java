package com.euchreleague.controller;

import com.euchreleague.entity.*;
import com.euchreleague.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/displayleague"}
)
public class AdminDisplayLeagues extends HttpServlet {

    GenericDao<User> userDao = new GenericDao(User.class);
    GenericDao<League> leagueDao = new GenericDao(League.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int leagueId = Integer.parseInt(req.getParameter("leagueid"));
        League league = leagueDao.getById(leagueId);

        boolean hasMatches = false;

        if (league.getMatches().size() > 0) {
            hasMatches = true;
        }

        boolean canBeScheduled = false;

        if (league.getUsers().size() == 16) {
            canBeScheduled = true;
        }

        req.setAttribute("hasMatches", hasMatches);
        req.setAttribute("canBeScheduled", canBeScheduled);
        req.setAttribute("league", league);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayLeague.jsp");

        dispatcher.forward(req, resp);


    }



}
