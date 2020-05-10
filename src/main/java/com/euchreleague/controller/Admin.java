package com.euchreleague.controller;

import com.euchreleague.entity.League;
import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/admin"}
)
public class Admin extends HttpServlet {

    GenericDao<User> userDao = new GenericDao(User.class);
    GenericDao<League> leagueDao = new GenericDao(League.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getRemoteUser();
        User user = userDao.getByPropertyEqual("userName", userName).get(0);

        boolean userIsAdmin = false;

        for (UserRoles role : user.getUserRoles()) {
            if (role.getRoleName().equals("admin")) {
                userIsAdmin = true;
            }
        }

        RequestDispatcher dispatcher;

        if (userIsAdmin == true) {
            req.setAttribute("upcomingLeagues",leagueDao.getAll());
            dispatcher = req.getRequestDispatcher("/admin.jsp");
        } else {
             dispatcher = req.getRequestDispatcher("/index.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
