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
<c:if test="${listSpice.size()>0}">
<ol>
    <c:forEach items="${listSpice}" var="spice">
        <li>${spice}</li>
    </c:forEach>
</ol>
</c:if>
<c:if test="${listSpice.size()=0}">
    <h3>Not choose spice sandwich</h3>
</c:if>
<a href="/">back menu</a>
</body>
</html>
