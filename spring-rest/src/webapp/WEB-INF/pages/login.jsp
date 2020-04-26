<%--
  Created by IntelliJ IDEA.
  User: Святослав
  Date: 25.11.2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Please sign in</h1>
<form method="post" action="/login">
    <input placeholder="Email address" name="j_username"/>
    <input placeholder="Password" name="j_password"/>
    <input type="submit" value="Sign in"/>
</form>
</body>
</html>
