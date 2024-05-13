package com.example.firstproject.liu.day02FilterListener;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/welcome.html")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //your  code....
        //获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            //未登录
            response.sendRedirect("/login.html");
        }else {
            chain.doFilter(request,response);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
