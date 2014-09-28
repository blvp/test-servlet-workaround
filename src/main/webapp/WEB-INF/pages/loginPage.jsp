<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 29.09.2014
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/login" method="get">
    <%--тип та ошибка которую мы послали из Login сервлета--%>
        <div style="color: red">${error}</div>
    <%--короче в запрос введенные тобой параметры из браузера уйдут как параметры соответствующие
        параметру name у инпута, то бишь чтобы получить введенное значение на сервлете тебе надо будет
        вызвать request.getParameter("login"); для логина и аналогично для пароля.
    --%>
    <input type="text" name="login"/>
    <input type="password" name="password"/>
    <button type="submit">Login</button>
</form>
</body>
</html>
