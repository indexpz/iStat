<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19/06/2021
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edytuj użytkownika</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <div><label>Nazwa użytkownika:</label>
    <form:input path="nickName"/>
    <form:errors path="nickName"/></div>
    <div><label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email"/> </div>
<%--    <div><label>Hasło:</label>--%>
<%--    <form:input path="password"/>--%>
<%--    <form:errors path="password"/> </div>--%>
    <form:hidden path="id"/>
    <div><button type="submit">Zmień</button> </div>
</form:form>
</body>
</html>
