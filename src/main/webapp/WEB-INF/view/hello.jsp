<%--
  Created by IntelliJ IDEA.
  User: hwangseong-in
  Date: 2017. 2. 20.
  Time: 오후 7:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>성인이</title>
</head>
<body>
<%
    String test = "sungin";
%>
<h1>성인이 컨트롤러 </h1>
<h2><c:out value="${hello}"/></h2>
<h2>${hello}</h2>
<h2><%= test %></h2>


</body>
</html>
