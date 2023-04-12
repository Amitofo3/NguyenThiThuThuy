package com.servlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public LoginServlet(){super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        System.out.println(user);
        System.out.println(pass);
        if("username".equals(user) && "password".equals(pass)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
            req.setAttribute("flashMessage","sai");
            req.setAttribute("flashType","");
            req.setAttribute("flashType","");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
