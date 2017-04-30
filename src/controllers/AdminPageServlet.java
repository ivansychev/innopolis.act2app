package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivans on 23/04/2017.
 */
@Controller
@RequestMapping(value="/adminPage")
public class AdminPageServlet extends HttpServlet {


    @RequestMapping(method = RequestMethod.GET)
    public String onGet()
    {
        return "adminPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onPost(SessionStatus sessionStatus)
    {
        sessionStatus.setComplete();
        return "welcomePage";
    }



    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminPage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("logout").equals("logout"))
        {
            req.getSession(false).invalidate();
            resp.sendRedirect("/app2act/");
        }
    }*/
}
