<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/16/2021
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            display: inline-block;
            padding: 1px 6px;
            border: solid black 1px;
            background-color: rgb(239, 239, 239);
        }
    </style>
</head>
<body>
<form:form modelAttribute="configurationEmail" action="/update" method="post">
    <fieldset>
        <legend>Setting</legend>
        <table>
            <tr>
                <th><label>Language :</label></th>
                <td><form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select></td>
            </tr>
            <tr>
                <th><label>Pages size</label></th>
                <td>
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="20">20</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <th><label>Spams filter :</label></th>
                <td><form:checkbox path="spamsFilter" value="true"/>Enables spams filter</td>
            </tr>
            <tr>
                <th><label>Signature :</label></th>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><form:button>Update</form:button></td>
                <td><a href="/">Cancel</a></td>
            </tr>
        </table>
    </fieldset

</form:form>
</body>
</html>
