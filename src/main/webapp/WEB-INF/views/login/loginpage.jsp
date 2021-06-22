<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22/06/2021
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<c:import url="../header_footer/header.jsp"/>
<div class="form-container">
<form method="post" action="/login">
    <div><input type="text" name="username" placeholder="Nazwa użytkownika"></div>
    <div><input type="password" name="password" placeholder="Hasło"></div>
    <div class="ui-button"><button type="submit">Zaloguj</button> </div>
</form>
</div>
</body>
</html>
