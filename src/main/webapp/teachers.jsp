<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subjects</title>
</head>
<body>
    <h3>Преподаватели</h3>

    <c:forEach items="${teachers}" var="t">
       ${t.lastName} ${t.firstName} ${t.middleName} <em>(id = ${t.id})</em></br>
    </c:forEach>

    <p>
        <em>(всего: ${fn:length(teachers)})</em>
    </p>
    
     <p>
        <em><a href="index.jsp">Назад</a></em>
    </p>
</body>
</html>
