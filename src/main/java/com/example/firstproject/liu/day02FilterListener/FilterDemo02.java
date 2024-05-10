package com.example.firstproject.liu.day02FilterListener;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/filterServlet01")
public class FilterDemo02 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("拦截前...");
        chain.doFilter(request, response);
        System.out.println("拦截后...");
    }

    public void destroy() {
    }
}
