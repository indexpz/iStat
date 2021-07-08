<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22/06/2021
  Time: 17:37
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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <link href="/webapp/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">
<div><h3>Witaj ${user.firstName} ${user.lastName}</h3></div>
    <div class="ui-button>"><a href="/logout">Wyloguj</a> </div>
    <div class="ui-button>"><a href="/user/edit">Edytuj Dane</a> </div>
<%--    <div class="ui-button>"><a href="/user/editusername">Zmień login/email</a> </div>--%>
<%--    <div class="ui-button>"><a href="/user/editpassword">Zmień hasło</a> </div>--%>
    <div class="ui-button>"><a href="/user/delete">Usuń użytkownika</a> </div>

</div>
</body>
</html>
