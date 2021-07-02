<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 23/06/2021
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista pojazdów</title>
</head>
<body>
<h3>Lista pojazdów użytkownika ${user.firstName} ${user.lastName}</h3>
<div><a href="/vehicle/add">Dodaj pojazd</a></div>

<c:forEach items="${vehicles}"  var="vehicle">
    <div>${vehicle.id} ${vehicle.vehicleName} ${vehicle.meterUnit} ${vehicle.fuelName} ${vehicle.fuelUnit} <a href="/vehicle-records/list?id=${vehicle.id}">Zarządzaj</a><a href="/vehicle/edit-data?id=${vehicle.id}">Edytuj dane</a><a href="/vehicle/delete?id=${vehicle.id}">Usuń</a></div>

</c:forEach>
</body>
</html>
