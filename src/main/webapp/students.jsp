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
    <h3>Студенты</h3>

    <c:forEach items="${students}" var="s">
       ${s.lastName} ${s.firstName} ${s.middleName} <em>(id = ${s.id})</em></br>
    </c:forEach>

    <p>
        <em>(всего: ${fn:length(students)})</em>
    </p>
    
     <p>
        <em><a href="index.jsp">Назад</a></em>
    </p>
</body>
</html>
