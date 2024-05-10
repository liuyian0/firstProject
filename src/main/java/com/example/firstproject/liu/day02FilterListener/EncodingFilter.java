package com.example.firstproject.liu.day02FilterListener;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //解决请求乱码
        request.setCharacterEncoding("utf-8");
        //解决请求乱码
        response.setContentType("text/html;charset=utf-8");
        //获取请求数据
        String username = request.getParameter("username");
        //输出数据
        System.out.println("username="+username);
        //响应数据给浏览器
        response.getWriter().print("username="+username);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
