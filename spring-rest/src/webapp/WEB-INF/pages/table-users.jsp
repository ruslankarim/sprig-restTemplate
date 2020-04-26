<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-04-01
  Time: 02:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1" cellpadding="5">
    <caption><h2>All users</h2></caption>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>Role</th>
        <c:forEach var="item" items="${users}">
            <tr>
                <td><c:out value="${item.id}" /></td>
                <td><c:out value="${item.firstName}" /></td>
                <td><c:out value="${item.lastName}" /></td>
                <td><c:out value="${item.age}" /></td>
                <td><c:out value="${item.email}" /></td>
                <td><c:forEach var="role" items="${item.roles}">
                    <c:out value="${role.toString()}"></c:out>
                </c:forEach>
                </td>
                <td>
                    <a href="admin/edit?id=<c:out value='${item.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="admin/delete?id=<c:out value='${item.id}' />">Delete</a>
                </td>
            </tr>
    </c:forEach>
    </tr>
</table>