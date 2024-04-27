package com.example.firstproject.web;

import com.example.firstproject.pojo.User;
import com.example.firstproject.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理post请求乱码
        request.setCharacterEncoding("utf-8");
        //2.获取页面数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.将请求参数封装到User实体类对象中
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //4.创建service业务层对象
        UserServiceImpl userService = new UserServiceImpl();
        //5.使用业务层对象调用业务层注册方法将User实体类对象传递给业务层
        boolean result = userService.register(user);
        //6.将返回值返回给前端服务器
        response.getWriter().print(result);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

