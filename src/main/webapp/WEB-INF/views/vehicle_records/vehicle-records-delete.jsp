<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 03/07/2021
  Time: 09:22
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
<form method="post" action="">
    <p>Czy usunąć tankowanie pojazdu o id ${vehicle.id}: ${vehicleRecord.data} o id = ${vehicleRecord.id}</p>
    <p>
        <input type="hidden" name="id" value="${vehicleRecord.id}">
        <a href="/vehicle-records/list?id=${vehicle.id}">
            Nie
        </a>
        <button type="submit">Tak</button>
    </p>
</form>

</body>
</html>
