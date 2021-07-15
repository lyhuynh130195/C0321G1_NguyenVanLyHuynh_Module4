<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/15/2021
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List spice sandwich</h1>

<ol>
    <c:forEach items="${listSpice}" var="spice">
        <li>${spice}</li>
    </c:forEach>
</ol>

<a href="/">back menu</a>
</body>
</html>
