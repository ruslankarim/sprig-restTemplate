<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-03-15
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users Application</title>
</head>
<body>
<center>
    <h1>Users Management</h1>
    <h2>
        <a href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="userlist">List All User</a>
    </h2>
</center>
<div align="center">
    <c:if test="${user != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.username}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.username}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Address: </th>
                    <td>
                        <input type="text" name="address" size="45"
                               value="<c:out value='${user.address}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="text" name="address" size="45"
                               value="<c:out value='${user.password}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>