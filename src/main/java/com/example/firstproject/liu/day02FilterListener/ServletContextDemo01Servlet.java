package com.example.firstproject.liu.day02FilterListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo01Servlet")
public class ServletContextDemo01Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上下文ServletContext对象
        ServletContext servletContext = getServletContext();
        //获取服务器中每个文件的路径（在web路径下存放一个图片文件）
        String realPath = servletContext.getRealPath("/xzq.jpg");
        System.out.println("realPath = " + realPath);//realPath = D:\develop\code\firstProject\target\firstProject-1.0-SNAPSHOT\xzq.jpg
        //获取当前项目下的xzq.jpg在服务器中的文件类型
        String mimeType = servletContext.getMimeType("xzq.jpg");
        System.out.println("mimeType = " + mimeType);//mimeType = image/jpeg

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

