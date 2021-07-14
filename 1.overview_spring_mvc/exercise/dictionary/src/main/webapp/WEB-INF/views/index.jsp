<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/14/2021
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div class="container">
    <div >
        <h3>English</h3>
        <form method="post" action="/translate">
            <input type="text" name="english" required>
            <input type="submit" value="search">
        </form>
    </div>
    <div>
    </div>
    <div>
        <h3>Việt Nam</h3>
      <p>${result}</p>
    </div>
</div>
</body>
</html>
