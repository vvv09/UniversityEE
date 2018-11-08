<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>classrooms</title>
</head>
<body>
	<h3>Аудитории</h3>

	<c:forEach items="${classrooms}" var="c">
	   ${c.name} </br>
	</c:forEach>

	<p>
		<em>(всего: ${fn:length(classrooms)})</em>
	</p>

	<p>
		<em><a href="index.jsp">Назад</a></em>
	</p>
</body>
</html>
