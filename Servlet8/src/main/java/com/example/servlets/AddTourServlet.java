package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddTourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Tour> tours = JDBC.getToursFromDB();
        req.setAttribute("tours", tours);
        req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String destination = req.getParameter("destination");
        String tourprice = req.getParameter("tourprice");


        ArrayList<Tour> tours = JDBC.getToursFromDB();
        int id = 1;
        for (Tour tour : tours) {
            if (tour.getFirstname().equals(firstName) && tour.getLastname().equals(lastName) && tour.getStartDate().equals(startDate) && tour.getEndDate().equals(endDate) && tour.getDestination().equals(destination) && tour.getTourprice().equals(tourprice)) {
                req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
            }
            else {
                id++;
            }
        }
        insertCard(id, firstName, lastName, startDate, endDate, destination, tourprice);
        resp.sendRedirect("/Servlet8/addTour");
    }

    public void insertCard(int tour_id, String fistName, String lastName, String startDate, String endDate, String destination, String tourprice) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/servlet8", "root", "1q2w3e4r5t27");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO tours (tour_id, firstname, lastname, startDate, endDate, destination, tourprice) VALUES (?, ?, ?, ?, ?, ?, ?)")) {


            statement.setLong(1, tour_id);
            statement.setString(2, fistName);
            statement.setString(3, lastName);
            statement.setString(4, startDate);
            statement.setString(5, endDate);
            statement.setString(6, destination);
            statement.setString(7, tourprice);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
