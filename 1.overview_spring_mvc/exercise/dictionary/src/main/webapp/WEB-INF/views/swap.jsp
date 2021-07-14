<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/14/2021
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Viet Nam - English</title>
    <style>
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
        .container{
            display: flex;
            justify-content: space-evenly;
        }
        .item{
            border: solid 1px black;
            width: 30%;
            height: 200px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="item">
        <h3>Việt Nam</h3>
        <form method="post" action="/swap/translate">
            <input type="text" name="vietNamese" required>
            <input type="submit" value="search">
        </form>
    </div>
    <div class="item2">
        <a href="/" class="button">Swap</a>
    </div>
    <div class="item">
        <h3>English</h3>
        <p>${result1}</p>
        <p style="color: #ebf5cc">${resultNotfound1}</p>
    </div>
</div>
</body>
</html>
