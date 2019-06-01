package cn.bloghut.filter;

import cn.bloghut.utils.Config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        //获取session
        HttpSession session = req.getSession();
        if((session.getAttribute(Config.UID) == null) ||
        ("".equals(session.getAttribute(Config.UID))) ||
        (session.getAttribute(Config.LOGIN_SUCCESS).toString() == null) ||
        (!Config.LOGIN_SUCCESS_VALUE.equals(session.getAttribute(Config.LOGIN_SUCCESS).toString()))
        ){
            res.sendRedirect("login.jsp");
            return;
        }
        //以上都不满足--放行
        chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
