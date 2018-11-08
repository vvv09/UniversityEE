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
	<h3>Расписание</h3>

	<c:forEach items="${schedule}" var="row" varStatus="status">
		<p>
			<strong> ${row.dayOfWeek} ${row.parity} ${row.lesson} </strong>
		</p>
		<c:forEach items="${row.lectures}" var="l">
			<p>
				<em> ${l.subject.name} - ${l.teacher.lastName} / ${l.group.name}
					/ ${l.classroom.name}</em>
			</p>
		</c:forEach>
	</c:forEach>

	<p>
		<em><a href="index.jsp">Назад</a></em>
	</p>
</body>
</html>
