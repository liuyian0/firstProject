package com.example.firstproject.liu.day01Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionAServlet")
public class SessionAServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Session持久化
        //1.创建Session对象
        HttpSession session = request.getSession();
        //2.获取Session的JSESSIOID的值
        String sessionId = session.getId();
        //3.创建Cookie，Cookie（"JSESSIOID",值）
        Cookie cookie = new Cookie("JSESSIOID", sessionId);
        //4.使用cookie对象调用方法setMaxAge()进行cookie的持久化，存活时间设置为30min
        cookie.setMaxAge(60*30);
        //5.将cookie响应给浏览器
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

