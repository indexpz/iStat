<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 16/06/2021
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utwórz użytkownika</title>
</head>
<body>
<form method="post" action="">
    <div>
        <label>Email:</label>
        <input type="email" name="email">
        <form:errors path="email"/>
    </div>
    <div>
        <label>Hasło:</label>
        <input type="password" name="password">
        <form:errors path="password"/>

    </div>
    <div>
        <button type="submit">Utwórz</button>
    </div>
</form>

</body>
</html>
