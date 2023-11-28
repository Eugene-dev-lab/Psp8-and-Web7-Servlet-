package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserViewCardServlet extends HttpServlet {

    private String destination = "destination";
    private String tourprice = "tourprice";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tour tour = JDBC.findTourFromDB(destination, tourprice);
        req.setAttribute("tour", tour);
        req.getRequestDispatcher("WEB-INF/JSP/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        destination = req.getParameter("destination");
        tourprice = req.getParameter("tourprice");

        resp.sendRedirect("/Servlet8/userViewCard");
    }

}

