<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 01/07/2021
  Time: 05:26
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
<div><h3>Użytkownik: ${user.firstName} ${user.lastName}, pojazd ${vehicle.vehicleName} o id = ${vehicle.id}</h3></div>
<div><a href="/vehicle-records/add">Dodaj tankowanie</a></div>
<c:forEach items="${vehicleRecords}"  var="vehicleRecords">
  <div>${vehicleRecords.id} ${vehicleRecords.data} ${vehicleRecords.distanceMeter} ${vehicleRecords.refueling} ${vehicleRecords.pricePerFuelUnit}<a href="/vehicle/edit?id=${vehicleRecords.id}">Zarządzaj</a><a href="/vehicle/edit-data?id=${vehicleRecords.id}">Edytuj dane</a><a href="/vehicle/delete?id=${vehicleRecords.id}">Usuń</a></div>

</c:forEach>
</body>
</html>
