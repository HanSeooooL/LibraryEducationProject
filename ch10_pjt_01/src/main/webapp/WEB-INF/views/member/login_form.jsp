<%--
  Created by IntelliJ IDEA.
  User: hanseol
  Date: 24. 11. 11.
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MEMBER LOGIN FORM</title>
</head>
<body>
<h3>MEMBER LOGIN FORM</h3>
<form action="<c:url value="/member/loginConfirm"/>"method="post">
    <input type="text" name="m_id">
    <input type="password" name="m_pw"><br>
    <input type="submit" value="login">
    <input type="reset" value="reset">
</form>
</body>
</html>
