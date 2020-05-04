package com.euchreleague.controller;

import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<UserRoles> userRoleDao = new GenericDao(UserRoles.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


//        int userId = 0;
//        List<UserRoles> userRoles = userRoleDao.getByPropertyEqual("userName", req.getRemoteUser());
//
//        String admin = "admin";
//        String roleName = userRoleDao.getByPropertyEqual("roleName", req.getRemoteUser())
////        logger.debug(user.toString());
//        if (userRoles.equals(roleName)) {
//            userId = userRoles.get(0).getId();
//        }
////        logger.debug(userID);
//
//        // set userID in session for use in calls to web service
//        session.setAttribute("userId", userId);
//
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(req, resp);
    }
}
