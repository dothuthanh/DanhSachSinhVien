<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 6/22/2020
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student Search</h1>
<c:if test='${requestScope["message"] != null}'>
    <p>
        <span class="message">${requestScope["message"]}</span>
    </p>
</c:if>
<p>
    <a href="/students">Back to product list</a>
</p>
<form method="POST">
    <fieldset>
        <legend>Search student</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="search" value="" placeholder="Nam student"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </fieldset>
</form>
<c:if test='${requestScope["results"] != null}'>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["results"]}' var="student">
            <tr>
                <td><a href="/student?action=view&id=${student.getId()}">${student.getName()}</a></td>
                <td>${student.getEmail()}</td>
                <td>${student.getAddress()}</td>
                <td><a href="/students?action=edit&id=${student.getId()}">edit</a></td>
                <td><a href="/students?action=delete&id=${student.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
