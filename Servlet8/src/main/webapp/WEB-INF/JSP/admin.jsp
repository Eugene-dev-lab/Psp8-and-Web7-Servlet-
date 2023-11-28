<%@ page language="java" contentType="text/html; charset=utf-8"
import="com.example.servlets.Tour"
import="java.util.ArrayList"
pageEncoding="utf-8"%>

<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;

        }

        .admin-block {
            border-bottom: 1px solid #ccc;
            margin-bottom: 20px;
            padding-bottom: 10px;
        }

        .admin-block h2 {
            color: #333;
            margin-bottom: 5px;
        }

        .admin-block a:hover {
            text-decoration: underline;
        }


        .form-container {
            width: 1400px;
            margin: 0 auto;
            background-color: beige;
            border: 3px solid black;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form-container label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        .form-container input[type="text"],
        .form-container input[type="date"],
        .form-container input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        .form-container input[type="submit"] {
                background-color: chartreuse;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
                width: 100%;
        }

        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        thead th {
            background-color: crimson;
            color: #fff;
            padding: 10px;
            text-align: left;
        }

        tbody td {
            border-bottom: 1px solid #ccc;
            padding: 10px;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody tr:hover {
            background-color: #eaeaea;
        }

        .admin-button {
                    display: inline-block;
                    background-color: gray;
                    color: #fff;
                    border: none;
                    padding: 10px 20px;
                    border-radius: 3px;
                    cursor: pointer;
                    font-size: 14px;
                    text-decoration: none;
                    transition: background-color 0.3s ease;
                }

                .admin-button:hover {
                    background-color: black;
                }
    </style>
</head>
<body>
<div class="admin-block">
    <h2>Admin</h2>
     <div>
                    <a class="admin-button" href="login">Выход</a>
                </div>
</div>


<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Destination</th>
        <th>Tour Price</th>
    </tr>
    </thead>
    <tbody>
    <% ArrayList<Tour> tours = (ArrayList<Tour>) request.getAttribute("tours"); %>
    <% for (Tour tour : tours) { %>
    <tr>
        <td><%= tour.getFirstname() %></td>
        <td><%= tour.getLastname() %></td>
        <td><%= tour.getStartDate() %></td>
        <td><%= tour.getEndDate() %></td>
        <td><%= tour.getDestination() %></td>
        <td><%= tour.getTourprice() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<h2>Add New Card</h2>
<div class="form-container">
    <form action="addTour" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required><br>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required><br>

        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" required><br>

        <label for="tourprice">Tour Price:</label>
        <input type="number" id="tourprice" name="tourprice" required><br>

        <input type="submit" value="Add Tour">
    </form>
</div>

</body>
</html>