package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ArrayList<User> users = JDBC.getUsersFromDB();

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password) && user.getRole().equals("user")) {
                resp.sendRedirect("/Servlet8/userViewCard");
                return;
            }
            else if(user.getLogin().equals(login) && user.getPassword().equals(password) && user.getRole().equals("admin")) {
                resp.sendRedirect("/Servlet8/addTour");
                return;
            }
        }
        req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);
    }
}
