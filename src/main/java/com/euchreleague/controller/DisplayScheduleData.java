package com.euchreleague.controller;

import com.euchreleague.entity.Match;
import com.euchreleague.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * The type Display schedule data.
 */
@WebServlet(
        urlPatterns = {"/schedules"}
)

public class DisplayScheduleData extends HttpServlet {

    /**
     * The Team dao.
     */
    private static final GenericDao<Match> matchDao = new GenericDao<>(Match.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Match> matches = matchDao.getAll();

        req.setAttribute("matches", matches);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/schedules.jsp");
        dispatcher.forward(req, resp);
    }
}