package controllers;

import model.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivans on 22/04/2017.
 */
public class WelcomePageServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(WelcomePageServlet.class);

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.
                processInjectionBasedOnServletContext(this,
                        config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcomePage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug(req.getParameter("firstname"));

        if(req.getParameter("form").equals("login"))
        {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = userService.auth(email,password);

            if(user!=null)
            {
                if(user.getUserRights().equals("admin"))
                {
                    req.getSession().setAttribute("adminLogin", email);
                    req.getSession().setAttribute("adminName", "" + user.getUserFirstname() + " " + user.getUserSurname());
                    resp.sendRedirect(req.getContextPath()+"/adminPage");
                    /*RequestDispatcher rd = req.getRequestDispatcher("/adminPage.jsp");
                    rd.forward(req,resp);*/
                }
                else
                {
                    req.getSession().setAttribute("userLogin", email);
                    req.getSession().setAttribute("userName", "" + user.getUserFirstname() + " " + user.getUserSurname());
                    resp.sendRedirect(req.getContextPath()+"/userPage");
                    /*RequestDispatcher rd = req.getRequestDispatcher("/userPage.jsp");
                    rd.forward(req,resp);*/
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
