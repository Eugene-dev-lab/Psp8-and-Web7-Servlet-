package com.example.servlets;
import java.sql.*;
import java.util.ArrayList;

public class JDBC {

    public static Connection connection = null;

    public static Tour findTourFromDB(String destination, String tourprice) {
        Tour Tour = new Tour();

        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM tours";
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                if(destination.equals(resultSet.getString("destination")) && tourprice.equals(resultSet.getString("tourprice"))) {
                    Tour.setTour_id(resultSet.getInt("tour_id"));
                    Tour.setFirstname(resultSet.getString("firstname"));
                    Tour.setLastname(resultSet.getString("lastname"));
                    Tour.setStartDate(resultSet.getString("startDate"));
                    Tour.setEndDate(resultSet.getString("endDate"));
                    Tour.setDestination(resultSet.getString("destination"));
                    Tour.setTourprice(resultSet.getString("tourprice"));
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }

        return Tour;
    }

    public static ArrayList<Tour> getToursFromDB() {
        ArrayList<Tour> tours = new ArrayList<>();
        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM tours";
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setTour_id(resultSet.getInt("tour_id"));
                tour.setFirstname(resultSet.getString("firstname"));
                tour.setLastname(resultSet.getString("lastname"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setEndDate(resultSet.getString("endDate"));
                tour.setDestination(resultSet.getString("destination"));
                tour.setTourprice(resultSet.getString("tourprice"));
                tours.add(tour);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
        return tours;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
//                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost/servlet8", "root", "1q2w3e4r5t27");
        if (connection == null) {
            throw new SQLException();
        } else {
        System.out.println("Successfully connected");
        }
    }

    public static ArrayList<User> getUsersFromDB() {
        ArrayList<User> users = new ArrayList<>();
        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM users";
//            System.out.println("users:");
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getLong("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
        return users;
    }
}
