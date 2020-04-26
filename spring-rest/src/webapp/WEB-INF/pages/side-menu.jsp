<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-04-01
  Time: 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside>
    <div>
        <c:if test="${isAdmin == true}">
            <a href="/admin">ADMIN</a>
        </c:if>
    </div>
    <div>
        <a href="/user">USER</a>
    </div>
</aside>