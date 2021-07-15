<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/15/2021
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spice Sandwich</title>
    <style>
      body{
        font-size: larger;
      }
    </style>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="post" >
    <input type="checkbox" id="lettuce" name="condiment" value="Lettuce">
    <label for="lettuce">Lettuce</label>

    <input type="checkbox" id="tomato" name="condiment" value="Tomato">
    <label for="tomato"> Tomato </label>

    <input type="checkbox" id="mustard" name="condiment" value="Mustard">
    <label for="mustard">Mustard</label>

    <input type="checkbox" id="sprouts" name="condiment" value="Sprouts">
    <label for="sprouts">Mustard</label>
    <br>
    <input type="submit" value="Save">
  </form>
  </body>
</html>
