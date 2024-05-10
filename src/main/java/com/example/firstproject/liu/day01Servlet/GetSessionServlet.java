package com.example.firstproject.liu.day01Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getSessionServlet")
public class GetSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取Session
        HttpSession session = request.getSession();
        //2.获取session的id
        String sessionId = session.getId();
        //3.从session中取出商品
        Product p = (Product) session.getAttribute("p");
        //4.响应数据
        response.getWriter().print("getSessionServlet...JSESSIOID="+sessionId+"p="+p.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

