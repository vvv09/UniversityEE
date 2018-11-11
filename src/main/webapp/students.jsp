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
	<table border="1" width="50%">
		<tr>
			<th>Ф.И.О.</th>
			<th>Группа</th>
			<th>ID</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.lastName} ${s.firstName} ${s.middleName}</td>
				<td>группе быть</td>
				<td>${s.id}</td>
				<td><a href="getStudentServlet?id=${s.getId()}">Edit</a></td>
				<td><a href="deleteStudentServlet?id=${s.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(students)})</em>
	</p>
	<p>
		<a href="addstudentform.jsp">Добавить студента</a>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
