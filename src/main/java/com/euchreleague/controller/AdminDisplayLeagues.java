package com.euchreleague.controller;

import com.euchreleague.api.JavaMail;
import com.euchreleague.entity.League;
import com.euchreleague.entity.Match;
import com.euchreleague.entity.Team;
import com.euchreleague.entity.User;
import com.euchreleague.persistence.GenericDao;
import com.euchreleague.util.PropertiesLoader;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.layout.StringBuilderEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/displayleague"}
)
public class AdminDisplayLeagues extends HttpServlet implements PropertiesLoader  {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private static final GenericDao<League> leagueDao = new GenericDao<>(League.class);
    private static final GenericDao<Team> teamDao = new GenericDao<>(Team.class);
    private static final GenericDao<Match> matchDao = new GenericDao<>(Match.class);

    private final JavaMail javaMail;

    public AdminDisplayLeagues() throws Exception {
        Properties properties = loadProperties("/javamail.properties");
        javaMail = new JavaMail(properties);
    }

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int leagueId = Integer.parseInt(req.getParameter("leagueid"));
        League league = leagueDao.getById(leagueId);

        List<User> users = league.getUsers();

        StringBuilder emailBuilder = new StringBuilder();

        // Building the list of recipients
        for (User user : users) {
            emailBuilder.append(user.getFirstName() + " " + user.getLastName() + " <" + user.getEmail() + ">,");
        }

        StringBuilder bodyBuilder = new StringBuilder();

        Calendar date = Calendar.getInstance();

        date.setTime(league.getStartDate());


        for (int week = 0; week < 8; week++) {
            // Randomize player(user) list
            // https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
            Collections.shuffle(users);
            for (int matchCounter = 0; matchCounter < 4; matchCounter++) {
                Match match = new Match();
                Team team1 = new Team();
                Team team2 = new Team();

                match.setDateOfPlay(date.getTime());
                team1.setPlayer1(users.get(matchCounter * 4));
                team1.setPlayer2(users.get(1 + matchCounter * 4));
                team2.setPlayer1(users.get(2 + matchCounter * 4));
                team2.setPlayer2(users.get(3 + matchCounter * 4));

                teamDao.insert(team1);
                teamDao.insert(team2);

                match.setTeam1(team1);
                match.setTeam2(team2);
                match.setLeague(league);
                match.setTableNumber(matchCounter + 1);

                matchDao.insert(match);

                bodyBuilder.append(match.toString() + "\n");
            }
            date.add(Calendar.DATE, 7);
        }

        javaMail.sendEmail(emailBuilder.toString(), league.getName(), bodyBuilder.toString());

        doGet(req, resp);

    }
}
