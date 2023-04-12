package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath()+"/login";
        String registerURI = request.getContextPath()+"/register";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerIn = session != null && session.getAttribute("user") != null;
        boolean registerRequest  = request.getRequestURI().equals(registerURI);


        if(loggedIn || loginRequest || registerIn || registerRequest ){
            filterChain.doFilter(request,servletResponse1);
        }else{
            servletResponse1.sendRedirect(loginURI);
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
