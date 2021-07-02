<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 29/06/2021
  Time: 17:22
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
    <p>Czy usunąć pojazd: ${vehicle.vehicleName} o id = ${vehicle.id}</p>
    <p>
        <input type="hidden" name="id" value="${vehicle.id}">
        <a href="/user/homepage">
            >Nie
        </a>
        <button type="submit">Tak</button>
    </p>
</form>

</body>
</html>
