
package com.euchreleague.controller;


import com.euchreleague.entity.League;
import com.euchreleague.entity.Match;
import com.euchreleague.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/leagues"}
)

public class DisplayLeagues extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao dao = new GenericDao(League.class);

        req.setAttribute("leagues", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/leagues.jsp");
        dispatcher.forward(req, resp);
    }
}