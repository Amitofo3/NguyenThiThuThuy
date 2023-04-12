package com.servlet;

import com.mysql.cj.Session;
import org.hibernate.SessionBuilder;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.entities.User;
import com.dao.UserDAO;
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("Fullname");
        String email = req.getParameter("Email");
        String pass = req.getParameter("Password");
        String confirmPass = req.getParameter("Confirm Password");
        String msg = "";
       if(fullname.isEmpty() || email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()){
           msg = "Please enter all";
       }else if(!pass.equals(confirmPass)){
           msg = "Please enter password again";
       }else {
            msg="success";
            User user = new User();
            user.setName("Username");
            user.setEmail("123@gmail.com");
            user.setPass("123");
            UserDAO userDAO = new UserDAO();
            userDAO.create(user);

       }
       if(msg != ""){
           req.setAttribute("flashMessage",msg);
           req.setAttribute("flashType","");
           req.getRequestDispatcher("register.jsp").forward(req,resp);
           req.getSession().setAttribute("email",email);
           resp.sendRedirect("/Lab5");
       }

    }
}
