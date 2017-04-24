package controllers;

import model.pojo.User;
import org.apache.log4j.Logger;
import services.UserService;
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
public class WelcomePage extends HttpServlet{

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcomePage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("firstname").isEmpty())
        {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = userService.auth(email,password);
            if(user!=null)
            {
                if(user.getUserRights().equals("admin"))
                {
                    req.getSession().setAttribute("adminLogin", email);
                    resp.sendRedirect(req.getContextPath()+"/adminPage");
                }
                else
                {
                    req.getSession().setAttribute("userLogin", email);
                    resp.sendRedirect(req.getContextPath()+"/userPage");
                    //logger.debug("user " + login + " logged");
                }
            }
            else
            {
                resp.sendRedirect(req.getContextPath()+"/errorAuth.jsp");
            }
        }
        else
        {
            userService.signup(new User("user",
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("email"),
                    req.getParameter("password")));
            resp.sendRedirect(req.getContextPath()+"/successSignUp.jsp");
        }
    }

}
