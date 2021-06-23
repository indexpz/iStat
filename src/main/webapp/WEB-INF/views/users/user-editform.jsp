<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 23/06/2021
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edycja użytkownika</title>
</head>
<body>
<div><h2>Edytuj ${user.firstName} ${user.lastName}</h2></div>
<form:form method="post" modelAttribute="user">
        <div> Id: ${user.id}</div>

<%--    <div><label>Email:<form:input path="username"/></label><form:errors path="username"/> </div>--%>
    <div> Email: ${user.username}</div>
    <div><label>Imię:<form:input path="firstName"/></label><form:errors path="firstName"/></div>
    <div><label>Nazwisko:<form:input path="lastName"/></label><form:errors path="lastName"/></div>
    <form:hidden path="username"/>
<%--    <form:hidden path="id"/>--%>
    <div>
        <button type="submit">Zmień</button>
    </div>
</form:form>


</body>
</html>
