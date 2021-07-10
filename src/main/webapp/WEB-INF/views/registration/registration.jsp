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

<form:form method="post" modelAttribute="user" action="/register">
    <div>
        <label>Email:
            <input type="email" name="username"/>
            <form:errors path="username"/>
        </label>
    </div>
    <div>
        <label>Hasło:
            <input type="password" name="password"/>
            <form:errors path="password"/>
        </label>
    </div>
    <div>
        <label>Imię:
            <input type="text" name="firstName"/>
            <form:errors path="firstName"/>
        </label>
    </div>
    <div>
        <label>Nazwisko:
            <input type="text" name="lastName"/>
            <form:errors path="lastName"/>
        </label>
    </div>
    <div>
        <button type="submit">Zarejestruj</button>
    </div>
</form:form>
</body>
</html>
