
package com.euchreleague.controller;


import com.euchreleague.entity.League;
import com.euchreleague.entity.User;
import com.euchreleague.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        urlPatterns = {"/leagues"}
)

public class DisplayLeagues extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<League> leagueDao = new GenericDao(League.class);
    GenericDao<User> userDao = new GenericDao(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("upcomingLeagues",leagueDao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/leagues.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] leagueIds = req.getParameterValues("leagues");

        String userName = req.getRemoteUser();
        User user = userDao.getByPropertyEqual("userName", userName).get(0);

        List<League> leagues = new ArrayList<>();

        for (String leagueId : leagueIds) {
            int id = Integer.parseInt(leagueId);
            League league = leagueDao.getById(id);
            leagues.add(league);
            user.addLeague(league);
        }

        userDao.saveOrUpdate(user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}