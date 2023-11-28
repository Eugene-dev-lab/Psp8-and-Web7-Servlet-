
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
            padding: 20px;
        }

        .admin-block {
                    border-bottom: 1px solid #ccc;
                    margin-bottom: 20px;
                    padding-bottom: 10px;
                }

                 .admin-block a:hover {
                            text-decoration: underline;
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

        h2 {

            color: #333;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        form {
            width: 493px;
            margin: 0 auto;
            background-color: cadetblue;
            border: 2px solid lightgoldenrodyellow;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: inline-block;
            vertical-align: top;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .card-info {
            display: inline-block;
            vertical-align: top;
            margin-left: 385px;
            padding: 14px;
            background-color: cornflowerblue;
            border: 3px solid black;
            border-radius: 5px;
        }

        .card-info h5 {
            margin-bottom: 10px;
            color: #333;
        }
    </style>
</head>
<body>
<div class="admin-block">
    <h2>User</h2>
     <div>
                    <a class="admin-button" href="login">Выход</a>
                </div>
</div>

<div class="card-form" style="display: inline-block;">
    <h2>Искать</h2>
    <form action="userViewCard" method="post">
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" required><br>

        <label for="tourprice">Tour price:</label>
        <input type="text" id="tourprice" name="tourprice" required><br>

        <input type="submit" value="Find card">
    </form>
</div>

<div class="card-info" style="width:493px;height:230px;margin-top:68px">
    <% Tour tour = (Tour)request.getAttribute("tour"); %>
    <% if(tour != null ){ %>
            <h5>First name: <%= tour.getFirstname() %></h5>
            <h5>Last name: <%= tour.getLastname() %></h5>
            <h5>Start date: <%= tour.getStartDate() %></h5>
            <h5>End date: <%= tour.getEndDate() %></h5>
            <h5>Destination: <%= tour.getDestination() %></h5>
            <h5>Tour price: <%= tour.getTourprice() %></h5>
    <% } %>
</div>

</body>
</html>
