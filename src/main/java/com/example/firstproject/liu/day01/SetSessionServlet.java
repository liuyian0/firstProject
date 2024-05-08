package com.example.firstproject.liu.day01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/setSessionServlet")
public class SetSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Session对象
        HttpSession session = request.getSession();
        //2.获取Session的id
        String sessionId = session.getId();
        //3.创建商品对象
        Product p = new Product("笔记本",1000);
        //4.将商品对象存储到Session中
        session.setAttribute("p",p);
        //5.响应数据
        response.getWriter().print("setSessionServlet..JSESSIOID="+sessionId);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

