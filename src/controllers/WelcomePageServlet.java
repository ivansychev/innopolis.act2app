package controllers;

import model.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;
import javax.servlet.http.HttpServlet;

/**
 * Created by ivans on 22/04/2017.
 */
@Controller
@SessionAttributes("login")
public class WelcomePageServlet extends HttpServlet{

    //private static final Logger logger = Logger.getLogger(WelcomePageServlet.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String onGet()
    {
        return "welcomePage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView onPost(@RequestParam(value = "form") String form,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "password")String password)
    {
        ModelAndView mav = new ModelAndView();
        if(form.equals("login"))
        {
            User user = userService.auth(email,password);
            if(user!=null)
            {
                if(user.getUserRights().equals("admin"))
                {
                    /*req.getSession().setAttribute("adminLogin", email);
                    req.getSession().setAttribute("adminName", "" + user.getUserFirstname() + " " + user.getUserSurname());*/
                    mav.addObject("login", email);
                    mav.setViewName("redirect:adminPage");
                    /*RequestDispatcher rd = req.getRequestDispatcher("/adminPage.jsp");
                    rd.forward(req,resp);*/
                }
                else
                {
                    /*req.getSession().setAttribute("userLogin", email);
                    req.getSession().setAttribute("userName", "" + user.getUserFirstname() + " " + user.getUserSurname());*/
                    mav.addObject("login", email);
                    mav.setViewName("redirect:userPage");
                   /* RequestDispatcher rd = req.getRequestDispatcher("/userPage.jsp");
                    rd.forward(req,resp);*/
                }
            }
            else
            {
                mav.setViewName("redirect:errorAuth");
            }
        }
        else
        {
           /* userService.signup(new User("user",
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("email"),
                    req.getParameter("password")));
            resp.sendRedirect(req.getContextPath()+"/successSignUp.jsp");*/
        }
        return mav;
    }


    /*@Override
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
                    *//*RequestDispatcher rd = req.getRequestDispatcher("/adminPage.jsp");
                    rd.forward(req,resp);*//*
                }
                else
                {
                    req.getSession().setAttribute("userLogin", email);
                    req.getSession().setAttribute("userName", "" + user.getUserFirstname() + " " + user.getUserSurname());
                    resp.sendRedirect(req.getContextPath()+"/userPage");
                    *//*RequestDispatcher rd = req.getRequestDispatcher("/userPage.jsp");
                    rd.forward(req,resp);*//*
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
    }*/

}
