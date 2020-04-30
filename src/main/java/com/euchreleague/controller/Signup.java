package com.slack2slack.controller;


import com.euchreleague.entity.User;
import com.euchreleague.entity.UserRoles;
import com.euchreleague.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (
        urlPatterns = { "/signup" }
)
public class Signup extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: uncomment lines here and in context.xml to implement password hashing
//        String plainTextPassword = req.getParameter("password");
//        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();
//        try {
//            credentialHandler.setAlgorithm("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            logger.error("Algorithm {} could not be found", "SHA-256");
//        }
//        credentialHandler.setEncoding("UTF-8");
//        String hashedPassword = credentialHandler.mutate(plainTextPassword);

        GenericDao userDao = new GenericDao(User.class);

        User user = new User(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("userName"),
                req.getParameter("password"),
                req.getParameter("email")
//              ,hashedPassword // use this line instead once password hashing is re-implemented
        );

        UserRoles userRoles = new UserRoles();
        userRoles.setRoleName("user");
        userRoles.setUserName(user.getUserName());
        user.addRole(userRoles);

        // Check if username already in database
        List<UserRoles> users = userDao.getByPropertyEqual("userName", req.getParameter("userName"));
        int newUserId = 0;
        String errorMessage = null;
        if (users.size() > 0) {
            errorMessage = "Username already exists. Please try a different name.";
        } else {
            newUserId = userDao.insert(user);
//            logger.debug("New user with id {} created", newUserId);
        }

//        logger.debug("Error message: {}", errorMessage);

        req.setAttribute("errorMessage", errorMessage);
        req.getRequestDispatcher("/signupConfirmation.jsp").forward(req, resp);
    }
}