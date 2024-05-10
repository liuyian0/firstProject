package com.example.firstproject.liu.day01Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cServlet")
public class CServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在Cookie中存储特殊字符

/*        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg","12 34");
        //2.将Cookie存储到浏览器端
        response.addCookie(cookie);
        //会报错*/

        //正确用法
        String str = "12 34";
        //1.编码
        String encode = URLEncoder.encode(str, "utf-8");
        Cookie cookie = new Cookie("msg",encode);
        //2.将Cookie存储到浏览器端
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

