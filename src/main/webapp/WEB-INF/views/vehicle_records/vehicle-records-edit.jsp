<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 01/07/2021
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div><h3>Użytkownik: ${user.firstName} ${user.lastName}, edytuj pojazd ${vehicle.vehicleName} o id = ${vehicle.id}</h3></div>
<form:form method="post" modelAttribute="vehicleRecord">
    <div><label>Data: <form:input path="data" type="data"/> <form:errors path="data"/></label></div>
    <div><label>Odczyt licznika <form:input path="distanceMeter"/><form:errors path="distanceMeter"/></label></div>
    <div><label>Ilość paliwa <form:input path="refueling"/><form:errors path="refueling"/></label></div>
    <div><label>Cena za jednostkę <form:input path="pricePerFuelUnit"/> <form:errors path="pricePerFuelUnit"/></label>
    </div>
<%--        <form:hidden path="${vehicle.id}" name="vehicleId"/>--%>
        <form:hidden path="${vehicleRecords.id}" />
    <div>
        <button type="submit">Dodaj</button>
    </div>
</form:form>
</body>
</html>
