<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e9ecef;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            width: 300px;
            background-color: coral;
            border: 2px solid #343a40;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }

        h2 {
            text-align: center;
            color: #343a40;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #343a40;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ced4da;
            border-radius: 3px;
            box-sizing: border-box;
            margin-bottom: 10px;
            color: #495057;
        }



        .registration-button {
            display: inline-block;
            background-color: green;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .registration-button:hover {
            background-color: greenyellow;
        }

        input[type="submit"] {
            background-color: crimson;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
            width: 100%;
            margin-bottom: 15;
            margin-top: 40px;
        }

        input[type="submit"]:hover {
            background-color: black;
        }
    </style>
</head>
<body>
    <div class="card">
        <form action="login" method="post">
            <h2>Вход</h2>

            <input type="text" id="login" name="login" placeholder="Login" required>


            <input type="password" id="password" name="password" placeholder="Password" required>

            <input type="submit" value="Login">

            <div class="registration-link">
                            <a class="registration-button" href="registration">Registration</a>
                        </div>
        </form>
    </div>
</body>
</html>