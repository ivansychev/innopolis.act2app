package controllers;

import org.apache.log4j.Logger;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivans on 22/04/2017.
 */
public class UserPageServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(UserPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userPage.jsp");
        logger.debug("GET REQUSET !");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("logout").equals("logout"))
        {
            req.getSession(false).invalidate();
            resp.sendRedirect("/app2act/");
        }
    }
}
