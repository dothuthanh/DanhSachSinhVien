<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 6/22/2020
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/students">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Student information</legend>
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
            <tr>
                <td><input type="submit" value="Delete student"></td>
                <td><a href="/students">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
