
package com.euchreleague.controller;


import com.euchreleague.entity.Match;
import com.euchreleague.entity.User;
import com.euchreleague.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/matches"}
)

public class DisplayMatchData extends HttpServlet {

    GenericDao<Match> matchDao = new GenericDao(Match.class);
    GenericDao<User> userDao = new GenericDao(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("matches", matchDao.getAll());
        req.setAttribute("users", userDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/matches.jsp");
        dispatcher.forward(req, resp);
    }
}