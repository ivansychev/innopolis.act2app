<%--
  Created by IntelliJ IDEA.
  User: ivans
  Date: 23/04/2017
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h1>Hello Admin!!</h1>
<form action="${pageContext.request.contextPath}/adminPage" method="post" ><button name="logout" type="submit" value="logout">Log out</button></form>
</body>
</html>
