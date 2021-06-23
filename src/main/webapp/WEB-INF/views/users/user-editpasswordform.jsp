<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 23/06/2021
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div><h2>Zmień hasło ${user.firstName} ${user.lastName}</h2></div>
<form:form method="post" modelAttribute="user">
    <div><label>Nowe hasło<form:input path="password" type="password"/></label><form:errors path="password"/> </div>
    <for:hidden path="username"/>
    </div>
    <div><button type="submit">Zmień hasło</button></div>
</form:form>
</body>
</html>
