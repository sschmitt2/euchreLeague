package com.euchreleague.controller;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The type Login.
 */
@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The User dao.
     */
    GenericDao<User> userDao = new GenericDao(User.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        int userId = 0;
        List<User> user = userDao.getByPropertyEqual("userName", req.getRemoteUser());


        if (user.size() == 1) {
            userId = user.get(0).getId();
        }


        session.setAttribute("userId", userId);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
