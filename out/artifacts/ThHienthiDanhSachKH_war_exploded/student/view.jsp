<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 6/22/2020
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View </title>
</head>
<body>
<h1>Student details</h1>
<p>
    <a href="/students">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["student"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["student"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
