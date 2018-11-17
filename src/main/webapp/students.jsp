<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>

	<c:set var="truePage" value="${true_page}" />
	<c:if
		test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetStudentListServlet')}">
		<c:redirect url="getStudentListServlet" />
	</c:if>

	<h3>Студенты</h3>
	<hr />
	<table width="50%">
		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.lastName} ${s.firstName} ${s.middleName}</td>
				<td><em>${s.group.name}</em></td>
				<td><a href="getStudentForEditServlet?id=${s.getId()}">Править</a></td>
				<td><a href="deleteStudentServlet?id=${s.getId()}">Удалить</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(students)})</em>
	</p>
	<hr />
	<p>
		<a href="getGroupsForNewStudentServlet">Добавить студента</a>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
