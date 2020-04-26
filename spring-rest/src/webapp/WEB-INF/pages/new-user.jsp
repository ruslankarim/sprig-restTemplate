<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-04-01
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:if test="${userEdit != null}">
        <form method="post" action="/admin/edit">
    </c:if>
    <c:if test="${userEdit == null}">
        <form method="post" action="/admin/new">
    </c:if>
    <c:if test="${userEdit != null}">
        <input type="hidden" name="id" value="<c:out value='${userEdit.id}' />"/>
    </c:if>
    <p><b>First name</b><br>
    <input required type="text" name="first_name" value="<c:out value='${userEdit.firstName}' />"/>
    <p><b>Last name</b><br>
    <input required type="text" name="last_name" value="<c:out value='${userEdit.lastName}' />">
    <p><b>Age</b><br>
    <input required type="number" name="age" value="<c:out value='${userEdit.age}' />">
    <p><b>Email</b><br>
    <input required type="text" name="email" value="<c:out value='${userEdit.email}' />">
    <p><b>Password</b><br>
    <input required type="text" name="password" value="<c:out value='${userEdit.password}' />">
    <p><b>Role</b><br>
    <p><input type="checkbox" value="ADMIN" name="ADMIN" <c:if test="${isAdminEdit == true}">checked</c:if>>ADMIN</p>
    <p><input type="checkbox" value="USER" name="USER" <c:if test="${userEdit != null}" >checked</c:if>>USER</p>
    <input type="submit" value="<c:if test="${userEdit == null}">Add new user</c:if> <c:if test="${userEdit != null}">Edit user</c:if>"/>
</form>