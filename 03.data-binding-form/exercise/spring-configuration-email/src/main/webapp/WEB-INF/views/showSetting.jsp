<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/16/2021
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Setting</h1>
<h3>Language : ${configurationEmail.language}</h3>
<h3>Page size : ${configurationEmail.pageSize}</h3>
<h3>Spams filter : ${configurationEmail.spamsFilter}</h3>
<h3>Signature : ${configurationEmail.signature}</h3>
<a href="/">Back menu</a>
</body>
</html>
