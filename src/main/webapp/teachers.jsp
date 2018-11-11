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
	<table border="1" width="50%">
		<tr>
			<th>Ф.И.О.</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${teachers}" var="t">
			<tr>
				<td>${t.lastName} ${t.firstName} ${t.middleName} <em>(${t.id})</em></td>
				<td><a href="getTeacherServlet?id=${t.getId()}">Edit</a></td>
				<td><a href="deleteTeacherServlet?id=${t.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(teachers)})</em>
	</p>
	<p>
		<a href="addteacherform.jsp">Добавить преподавателя</a>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
