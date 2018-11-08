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
    <h3>Предметы</h3>

    <c:forEach items="${subjects}" var="s">
       ${s.name} </br>
    </c:forEach>

    <p>
        <em>(всего: ${fn:length(subjects)})</em>
    </p>
    
     <p>
        <em><a href="index.jsp">Назад</a></em>
    </p>
</body>
</html>
