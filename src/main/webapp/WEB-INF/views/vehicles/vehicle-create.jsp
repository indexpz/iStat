<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 23/06/2021
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dodaj pojazd</title>
</head>
<body>
<form:form method="post" modelAttribute="vehicle">
    <div><label>Nazwa pojazdu <form:input path="vehicleName"/> <form:errors path="vehicleName"/></label></div>
    <div><label>Jednostki <form:select path="meterUnit" items="${meterUnit}" /></label></div>
    <div><label>Rodzaj paliwa <form:select path="fuelName" items="${fuelName}" /></label></div>
    <div><label>Jednostki paliwa <form:select path="fuelUnit" items="${fuelUnit}"/> <form:errors path="fuelUnit"/></label></div>
    <%--    <form:hidden path="userID"/>--%>
    <div>
        <button type="submit">Dodaj</button>
    </div>
</form:form>
</body>
</html>
