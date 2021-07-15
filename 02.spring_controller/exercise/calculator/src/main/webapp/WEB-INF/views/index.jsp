<%--
  Created by IntelliJ IDEA.
  User: Sony-VaiO
  Date: 7/15/2021
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        .item{
            margin: 20px;
        }
        .container{
            border: solid black 1px;
            width: 45%;
        }
        button{
            width: 100px;
        }
    </style>

</head>
<body>
<h1>Calculator</h1>
<div class="container">
    <br>
    <form id="calForm" action="/calculate" method="post">
        <div class="time">
            <label>number 1:
                <input type="number" name="num1" value="0">
            </label>
            <label>number 2:
                <input type="number" name="num2" value="0">
            </label>
        </div>
        <div class="item">
            <button type="button" id="addition" onclick="doCalculate(this.id)">Addition(+)</button>
            <button type="button" id="subtract" onclick="doCalculate(this.id)">Subtraction(-)</button>
            <button type="button" id="multiply" onclick="doCalculate(this.id)">Multiplication(*)</button>
            <button type="button" id="division" onclick="doCalculate(this.id)">Division(/)</button>
            <input type="hidden" name="bt_type" id="bt_type">
        </div>
    </form>
</div>
<h3>result: ${result}</h3>
</body>
<script>
    function doCalculate(id) {
        document.getElementById("bt_type").value = id;
        document.getElementById("calForm").submit();
    }
</script>
</body>
</html>
