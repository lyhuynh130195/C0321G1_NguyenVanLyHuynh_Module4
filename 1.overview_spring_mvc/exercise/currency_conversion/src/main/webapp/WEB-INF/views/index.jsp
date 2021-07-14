<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/14/2021
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
    <style>
        input[type=text]{
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
        p{
            color: red;
        }
    </style>
</head>
<body>
<div>
    <form action="/convert" method="post">
        <label for="usd">USD</label>
        <input type="text" id="usd" name="usd" required>
        <p>${exception}</p>

        <label for="exchangeRate">Exchange Rate</label>
        <input type="text" id="exchangeRate" name="exchangeRate" required>
        <p>${exception}</p>

        <input type="submit" value="Convert">
    </form>
</div>
<h3>Result :${result}</h3>


</body>
</html>
