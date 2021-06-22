<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22/06/2021
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rejestracja użytkownika</title>
</head>
<body>
<c:import url="../header_footer/header.jsp"/>
<form method="post" action="/register">
    <div>
        <label>Email:
        <input type="text" name="username"/>
        </label>
    </div>
    <div>
        <label>Hasło:
            <input type="password" name="password"/>
        </label>
    </div>
    <div>
        <label>Imię:
            <input type="text" name="firstName"/>
        </label>
    </div>
    <div>
        <label>Nazwisko:
            <input type="text" name="lastName"/>
        </label>
    </div>
    <div>
        <button type="submit">Zarejestruj</button>
    </div>
</form>
</body>
</html>
