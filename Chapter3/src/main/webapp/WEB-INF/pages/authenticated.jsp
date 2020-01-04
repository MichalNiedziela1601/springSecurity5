<%--
  Created by IntelliJ IDEA.
  User: sunday
  Date: 30/12/2019
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring Security authentication example</title>
</head>
<body>
<h2>Welcome to Spring Security authenrication example!</h2><br>
Your username is: <strong>${user}</strong><br>
<sec:authorize access="hasRole('ADMIN')">Your provided Admin authentication credentials!</sec:authorize>
<br>

<sec:authorize access="hasRole('USER')">Your provided User authentication credentials!</sec:authorize>
<br>
<br>

<a href="<c:url value="/logout"/>">Logout</a>
</body>
</html>
