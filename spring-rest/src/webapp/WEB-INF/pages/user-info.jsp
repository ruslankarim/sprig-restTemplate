<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-04-01
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1" cellpadding="5">
    <caption><h2>About user</h2></caption>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>Role</th>
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.firstName}" /></td>
                <td><c:out value="${user.lastName}" /></td>
                <td><c:out value="${user.age}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:forEach var="role" items="${user.roles}">
                    <c:out value="${role.toString()}"></c:out>
                </c:forEach>
        </td>
    </tr>
    </tr>
</table>