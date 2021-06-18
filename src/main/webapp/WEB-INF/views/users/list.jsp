<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 18/06/2021
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista użytkowników</title>
</head>
<body>
<c:forEach items="users" var="user">
    <div><p>Id: ${user.id}, psełdonim: ${user.nickName}, email: ${user.email}, hasło: ${user.password} </p></div>
</c:forEach>
</body>
</html>
