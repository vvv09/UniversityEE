<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classroom List</title>
</head>
<body>

	<c:set var="truePage" value="${true_page}" />
	<c:if
		test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetClassroomListServlet')}">
		<c:redirect url="getClassroomListServlet" />
	</c:if>

	<h3>Аудитории</h3>
	<hr />
	<table width="50%">
		<c:forEach items="${classrooms}" var="c">
			<tr>
				<td>${c.name}</td>
				<td><a href="getClassroomServlet?id=${c.getId()}">Править</a></td>
				<td><a href="deleteClassroomServlet?id=${c.getId()}">Удалить</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(classrooms)})</em>
	</p>
	<hr />
	<p>
		<a href="addclassroomform.jsp">Добавить аудиторию</a>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
