package com.example.firstproject.web;

import com.example.firstproject.pojo.User;
import com.example.firstproject.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理post请求乱码问题
        request.setCharacterEncoding("utf-8");
        //2.获取前端浏览器提交的数据(可抓包获得)
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.创建User对象
        User user = new User();
        //4.将接收到的前端数据封装到User对象中
        user.setUsername(username);
        user.setPassword(password);
        //5.创建业务层对象
        UserServiceImpl userService = new UserServiceImpl();
        //6.使用业务层对象调用业务层登陆方法将User对象进行传递
        User u = userService.login(user);
        //7.判断业务层返回的对象u是否等于null
        if (u == null) {
            //7.1u为null，说明根据用户名和密码未找到数据，即登陆失败，返回前端false
            response.getWriter().print(false);
        }else {
            //7.2u不为null，说明根据用户名和密码找到数据，登陆成功，返回前端true
            response.getWriter().print(true);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

