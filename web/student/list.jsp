<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 6/22/2020
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1>Danh sach HV</h1>
<table>
    <tr>
        <td>name</td>
        <td>email</td>
        <td>address</td>
    </tr>

    <c:forEach items='${requestScope["studentList"]}' var="student">
        <tr>
            <td>${student.getName()}</td>
            <td>${student.getEmail()}</td>
            <td>${student.getAddress()}</td>
            <td><a href="/students?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="/students?action=delete&id=${student.getId()}">delete</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
