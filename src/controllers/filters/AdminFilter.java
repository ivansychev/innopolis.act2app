package controllers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivans on 23/04/2017.
 */
public class AdminFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String adminLogin = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("adminLogin");
        if(adminLogin!=null)
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest)servletRequest).getContextPath() +  "/");
        }
    }

    public void destroy() {

    }
}
