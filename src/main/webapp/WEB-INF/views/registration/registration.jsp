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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <link href="/webapp/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<form:form method="post" modelAttribute="data" action="/register">
    <div>
        <label>Email:
            <input type="email" name="username" value="${data.username}"/>
            <form:errors path="username" element="div"/>
        </label>
    </div>
    <div>
        <label>Hasło:
            <input type="password" name="password"/>
            <form:errors path="password" element="div"/>
        </label>
    </div>
    <div>
        <label>Imię:
            <input type="text" name="firstName"/>
            <form:errors path="firstName" element="div"/>
        </label>
    </div>
    <div>
        <label>Nazwisko:
            <input type="text" name="lastName"/>
            <form:errors path="lastName"  element="div"/>
        </label>
    </div>
    <div>
        <button type="submit">Zarejestruj</button>
    </div>
</form:form>
</body>
</html>
