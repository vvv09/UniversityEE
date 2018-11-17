<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher List</title>
</head>
<body>

	<c:set var="truePage" value="${true_page}" />
	<c:if
		test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetTeacherListServlet')}">
		<c:redirect url="getTeacherListServlet" />
	</c:if>

	<h3>Преподаватели</h3>
	<hr />
	<table width="50%">
		<c:forEach items="${teachers}" var="t">
			<tr>
				<td>${t.lastName} ${t.firstName} ${t.middleName}</td>
				<td><a href="getTeacherScheduleServlet?id=${t.getId()}">Посмотреть расписание</a></td>
				<td><a href="getTeacherServlet?id=${t.getId()}">Править</a></td>
				<td><a href="deleteTeacherServlet?id=${t.getId()}">Удалить</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(teachers)})</em>
	</p>
	<hr />
	<p>
		<a href="addteacherform.jsp">Добавить преподавателя</a>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
