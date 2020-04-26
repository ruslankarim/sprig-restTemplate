<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
   <span><c:out value="${user.email}"/></span>
    <span>with:</span>
    <span><c:forEach items="${user.roles}" var="role">
                ${role.toString()}
            </c:forEach></span>
    <a href="/logout">logout</a>
</nav>
